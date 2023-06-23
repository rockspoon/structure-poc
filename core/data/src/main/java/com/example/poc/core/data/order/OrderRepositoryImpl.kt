package com.example.poc.core.data.order

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.work.Constraints
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.ExistingWorkPolicy
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.OutOfQuotaPolicy
import androidx.work.WorkInfo
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.example.poc.core.common.concurrency.WorkDataKeys
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import timber.log.Timber


// By having the REST API and database calls in data sources, I can, for example, just mock my
// remote data source returning whatever I want and I will not need to make calls to remote server
// and I still can test my logic implementation regarding the database synchronization, like in the
// insert method.
internal class OrderRepositoryImpl(
    private val workManager: WorkManager,
    private val orderDatabaseDataSource: OrderDatabaseDataSource,
    private val remoteServerDataSource: OrderRemoteServerDataSource,
    private val orderLocalServerDataSource: OrderLocalServerDataSource
) : OrderRepository {

    override suspend fun getOrder(id: Long): Order? {

        // Always get order from database as it's our source of truth. If the data in the server
        // changes, a push notification should with the sync message should be send to the device
        // so it pull a new order and insert it in the database.
        return orderDatabaseDataSource.getOrder(id)
    }

    /**
     * Returns a coroutine Flow<Order?> that observes changes in the
     * [androidx.room.Database].
     */
    override fun observeOrder(id: Long): Flow<Order?> {
        return orderDatabaseDataSource.observeOrder(id)
    }

    /**
     * Insert a Order first in the remote sever, than in the device database, returning the entity.
     */
    override suspend fun insertOrder(order: Order): Order {

        // Insert in the server, get the response...
        val remoteOrder = remoteServerDataSource.insertOrder(order)

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return orderDatabaseDataSource.saveOrder(remoteOrder)
    }

    /**
     * A sync function that can be used by the sync service.
     */
    // TODO This sync function is calling the remote server. I need to implement the business logic
    //      that choose between remote and local server, as well as make sure there is no conflict.
    // Need also a rule to enter contingency mode
    override suspend fun syncOrder(orderId: Long): Order {

        // Fetch in the server, get the response...

        // TODO I am not respecting the single source of truth principle between local and remote
        //      server. This will give some inconsistencies.
        //      I can always get from the local server and insert on the local or remote. this will
        //      give eventual consistency?
        val order: Order = try {
            remoteServerDataSource.getOrder(orderId)
                ?: throw OrderRepository.OrderRemoteNotFoundException(orderId)
        } catch (e: OrderRemoteServerDataSource.SeverUnavailableException) {
            orderLocalServerDataSource.getOrder(orderId)
                ?: throw OrderRepository.OrderRemoteNotFoundException(orderId)
        } catch (e: Exception) {
            throw e
        }

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return orderDatabaseDataSource.saveOrder(order)
    }

    /**
     * This implementation uses the local server. It's responsibility of the local server
     * call the remote server. The drawback is that if the local network or local sever
     * is down the system will not work.
     *
     * We could implement logic to redirect the calls to another server.
     */
    suspend fun syncOrder2(orderId: Long): Order {

        // Fetch in the local server, get the response...
        val order: Order = try {
            orderLocalServerDataSource.getOrder(orderId)
                ?: throw OrderRepository.OrderRemoteNotFoundException(orderId)
        } catch (e: Exception) {
            throw e
        }

        // ...then insert in our database before returning it, preserving local database as single
        // source of truth.
        return orderDatabaseDataSource.saveOrder(order)
    }

    /**
     * Enqueue a work with WorkManager to send the data to the server.
     *
     * The work will only be performed when the battery is not low and there is internet connection.
     */
    private fun requestSendData(orderId: Long): Flow<WorkInfo> {
        return OneTimeWorkRequestBuilder<SyncWorker>()
            // Run sync as expedited work if the app is able to.
            // If not, it runs as regular work.
            .setInputData(
                Data.Builder()
                    .putLong(ORDER_ID_KEY, orderId)
                    .build()
            )
            .setExpedited(OutOfQuotaPolicy.RUN_AS_NON_EXPEDITED_WORK_REQUEST)
            .setConstraints(
                Constraints.Builder()
                    .setRequiredNetworkType(NetworkType.CONNECTED)
                    .build()
            )
            .build()
            .let {
                // If it's necessary to sync again before a sync work is finish, we replace
                // the old sync request with the new one.
                workManager
                    .enqueueUniqueWork(it.id.toString(), ExistingWorkPolicy.REPLACE, it)
                workManager.getWorkInfoByIdLiveData(it.id).asFlow()
            }
    }

    /**
     * A Worker that updates all Preferences local data on the server.
     */
    // TODO [Tech Debt] Not working.
    inner class SyncWorker(
        appContext: Context,
        val workerParams: WorkerParameters
    ) : CoroutineWorker(appContext, workerParams) {

        override suspend fun doWork(): Result {
            return try {
                // Note: We don't actually care about the sync progress of preferences, but
                // we leave here as example to future implementations where this is important.
                setProgress(workDataOf(WorkDataKeys.PROGRESS to 0))
                val orderId = workerParams.inputData.getLong(ORDER_ID_KEY, -1)
                val order = orderDatabaseDataSource.getOrder(orderId)
                remoteServerDataSource.insertOrder(order)
                setProgress(workDataOf(WorkDataKeys.PROGRESS to 100))
                Result.success()
            } catch (e: HttpException) {
                if (e.code() == 503) Result.retry()
                else {
                    Timber.e(
                        message = "Network failure syncing Preferences object.",
                        t = e,
                        args = arrayOf("TAG")
                    )
                    Result.failure()
                }
            } catch (t: Throwable) {
                Timber.e(t)
                Result.failure()
            }
        }
    }

    companion object {
        const val ORDER_ID_KEY = "ORDER_ID_KEY"
    }
}
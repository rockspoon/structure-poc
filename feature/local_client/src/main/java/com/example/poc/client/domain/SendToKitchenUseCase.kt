package com.example.poc.client.domain

import com.example.poc.core.data.order.Order
import com.example.poc.core.data.order.OrderRepository
import com.example.poc.core.domain.base.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import timber.log.Timber

/**
 * Change the status of an order to IN_PROGRESS.
 */
// We don't know here which datasource the repository will use to sync the data. I am not sure
// if this is the intended behaviour.
/// If this do not depend on the datasource, this could be at the core module.
class SendToKitchenUseCase(
    private val orderRepository: OrderRepository,
    private val retryTimeIntervalInMillis: Long = 1_000L,
    private var retryTimeInMillis: Long = 3_000L,
    private var retryAttempts: Int = 3,
    private val coroutineDispatcher: CoroutineDispatcher
) {

    operator fun invoke(order: Order): Flow<UseCase.Result<Order>> = flow {
        // Emit the result if don't throw
        val orderSynced = updateOrderToInProgress(order, this)
        emit(UseCase.Result.Success(data = orderSynced))

    }.flowOn(coroutineDispatcher)

    private suspend fun updateOrderToInProgress(
        order: Order,
        flowCollector: FlowCollector<UseCase.Result<Order>>
    ): Order {

        // One attempt already done
        retryAttempts -= 1

        return try {
            // ...Change the status and update in the repository
            order.copy(status = Order.Status.IN_PROGRESS).also {
                // TODO Create update method
                orderRepository.insertOrder(it)
            }

        } catch (e: ServerUnavailableException) {

            // Emit a result "retrying in 3 seconds" updating it every second (countdown)
            while (retryTimeInMillis > 0) {
                flowCollector.emit(UseCase.Result.Retrying(timeInMillisUntilRetry = retryTimeInMillis))
                delay(retryTimeIntervalInMillis)
                retryTimeInMillis -= retryTimeIntervalInMillis
            }

            // Try again recursively after countdown finish until retry attempts is zero
            if (retryAttempts > 0) updateOrderToInProgress(order, flowCollector)
            else throw MaxRetryException()

        } catch (e: BadRequestException) {
            // Don't emit here, it's violation of transparency. The FlowUseCase class handles the
            // error
            throw e
        } catch (e: Exception) {
            Timber.e(e)
            throw e
        }
    }

    class MaxRetryException : RuntimeException()

    class BadRequestException : RuntimeException()

    class ServerUnavailableException : RuntimeException()
}
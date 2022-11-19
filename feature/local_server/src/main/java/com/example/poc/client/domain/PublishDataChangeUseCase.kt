package com.example.poc.client.domain

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import com.example.poc.client.data.Subscription
import com.example.poc.client.data.SubscriptionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach

class PublishDataChangeUseCase(
    private val workManager: WorkManager,
    private val subscriptionRepository: SubscriptionRepository
) {

    operator fun invoke(entityId: Long) {
        // TODO log notifications??

        subscriptionRepository.listSubscriptions(
            entityId = entityId,
            entityType = Subscription.Type.ORDER
        ).onEach {

            val publishWorkRequest = OneTimeWorkRequestBuilder<PublishWorker>()
                .build()
            workManager.enqueue(publishWorkRequest)

        }.flowOn(Dispatchers.IO)
    }

    class PublishWorker(
        appContext: Context,
        workerParams: WorkerParameters
    ) : CoroutineWorker(appContext, workerParams) {

        override suspend fun doWork(): Result {
            // TODO Pseudo code
//            val response = PublishApiService.request(
//                httpRequest = POST,
//                url = subscriber.webhook,
//                body = DataChangeMessage(id, type)
//            ).execute()

            // Indicate whether the work finished successfully with the Result
            return Result.success()
        }
    }

}
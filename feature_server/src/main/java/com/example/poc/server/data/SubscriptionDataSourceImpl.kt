package com.example.poc.server.data

import androidx.datastore.core.DataStore
import com.example.poc.datasource.serverdatastore.subscription.SubscriptionProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class SubscriptionDataSourceImpl(
    private val subscriptionDataStore: DataStore<SubscriptionProto>
) : SubscriptionDataSource {

    override suspend fun deleteSubscription(id: Long) {
        subscriptionDataStore.updateData { subscriptionProto ->
            subscriptionProto.toBuilder().clear().build()
        }
    }

    override suspend fun insertSubscription(subscription: Subscription) {
        subscriptionDataStore.updateData {
            subscription.toProto()
        }
    }

    override fun listSubscriptions(entityId: Long, entityType: EntityType): Flow<Subscription> =
        subscriptionDataStore.data.map {
            it.toModel()
        }

    private fun SubscriptionProto.toModel() =
        Subscription(
            id = id,
            webHook = webhook
        )

    private fun Subscription.toProto() =
        SubscriptionProto.newBuilder()
            .setId(this.id ?: 0)
            .setWebhook(this.webHook)
            .build()
}
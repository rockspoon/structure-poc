package com.example.poc.client.data

import androidx.datastore.core.DataStore
import com.example.poc.datasource.serverdatastore.subscription.SubscriptionProto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
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

    override fun listSubscriptions(
        entityId: Long,
        entityType: Subscription.Type
    ): Flow<Subscription> = subscriptionDataStore.data
        .filter { it.entityId == entityId && it.entityType == entityType.name }
        .map {
            it.toModel()
        }

    private fun SubscriptionProto.toModel() =
        Subscription(
            id = id,
            entityId = entityId,
            entityType = Subscription.Type.valueOf(entityType),
            webHook = webhook
        )

    private fun Subscription.toProto() =
        SubscriptionProto.newBuilder()
            .setId(this.id ?: 0)
            .setEntityId(this.entityId)
            .setEntityType(this.entityType.name)
            .setWebhook(this.webHook)
            .build()
}
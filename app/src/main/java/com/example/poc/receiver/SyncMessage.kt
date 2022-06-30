package com.example.poc.receiver

data class SyncMessage(
    val entityType: EntityType,
    val entityId: Long
) {
    enum class EntityType {
        ORDER
    }
}
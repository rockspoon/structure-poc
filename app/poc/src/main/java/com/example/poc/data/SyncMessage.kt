package com.example.poc.data

data class SyncMessage(
        val entityType: EntityType,
        val entityId: Long
) {
    enum class EntityType {
        ORDER
    }
}
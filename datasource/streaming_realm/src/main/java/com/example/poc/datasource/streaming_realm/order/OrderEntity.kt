package com.example.poc.datasource.streaming_realm.order

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PersistedName
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId

@PersistedName("order")
open class OrderEntity : RealmObject {

    @PrimaryKey
    @PersistedName("_id")
    var id: ObjectId? = ObjectId()

    var name: String? = null

}
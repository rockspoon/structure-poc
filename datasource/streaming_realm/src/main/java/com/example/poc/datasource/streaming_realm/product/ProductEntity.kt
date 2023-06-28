package com.example.poc.datasource.streaming_realm.product

import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PersistedName
import io.realm.kotlin.types.annotations.PrimaryKey
import org.mongodb.kbson.ObjectId
import java.math.BigDecimal

@PersistedName("product")
open class ProductEntity : RealmObject {

    @PrimaryKey
    @PersistedName("_id")
    var id: ObjectId? = ObjectId()

    var title: String = ""

    var description: String? = null

    var imageUrl: String? = null

    var priceInCents: Long = 0

}
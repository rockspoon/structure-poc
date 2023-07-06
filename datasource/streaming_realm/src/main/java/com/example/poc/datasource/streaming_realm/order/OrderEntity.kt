package com.example.poc.datasource.streaming_realm.order

import io.realm.kotlin.ext.realmListOf
import io.realm.kotlin.types.EmbeddedRealmObject
import io.realm.kotlin.types.RealmList
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

    var items: RealmList<Item> = realmListOf()

    var embeddedItems: RealmList<EmbeddedItem> = realmListOf()

    // @PersistedName does not work when used in a RealmList for some reason
//    @PersistedName("order_item")
    open class Item : RealmObject {

        @PrimaryKey
        @PersistedName("_id")
        var id: ObjectId? = ObjectId()

        var productId: ObjectId = ObjectId()

        var quantity: Int = 1

    }

    open class EmbeddedItem : EmbeddedRealmObject {
        var productId: ObjectId = ObjectId()

        var quantity: Int = 1
    }
}
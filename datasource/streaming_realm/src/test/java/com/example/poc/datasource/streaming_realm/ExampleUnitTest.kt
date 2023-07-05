package com.example.poc.datasource.streaming_realm

import com.example.poc.datasource.streaming_realm.order.OrderEntity
import kotlinx.coroutines.test.runTest
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

	@Test
	fun realmLogin() = runTest {
		// Init realm without login
		RealmDatabase.init()

		// insert an order
		RealmDatabase.instance.write {
			OrderEntity()
		}

		// log in
		val accessToken = ""
		//RealmDatabase.init(accessToken)

		// check if it was synced

	}
}
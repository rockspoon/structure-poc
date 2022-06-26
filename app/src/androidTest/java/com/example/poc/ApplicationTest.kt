package com.example.poc

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * A test application for instrumented tests end-to-end that overrides the coroutines
 * dispatchers.
 */
class ApplicationTest : Application() {

    override fun initKoin() {

        val testModule = module {

            // Change all the dispatchers to coroutine TestDispatcher so we can
            // sync the interface actions and the data flow on the tests.
            // We are giving the Main dispatcher because the TestScope do the job of calling
            // Dispatchers.setMain(TestDispatcher()), so Dispatchers.Main becomes TestDispatcher()
            single<CoroutineDispatcher> {
                Dispatchers.Main
            }

            single<CoroutineDispatcher>(Qualifiers.dispatcherIO) {
                Dispatchers.Main
            }

            // Other factories, like a mocked repository, belongs to the individual tests, not here.
        }

        // Start dependency injection
        startKoin {
            androidContext(this@ApplicationTest)
            modules(
                moduleList + testModule
            )
        }

    }
}

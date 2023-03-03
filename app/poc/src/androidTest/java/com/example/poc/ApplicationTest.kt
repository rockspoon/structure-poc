package com.example.poc

import androidx.multidex.MultiDexApplication
import com.example.poc.core.common.coreCommonModule
import com.example.poc.core.common.di.CoroutineQualifiers
import com.example.poc.core.data.coreDataModule
import com.example.poc.core.data.user.UserRemoteDataSource
import com.example.poc.core.domain.coreDomainModule
import com.example.poc.core.ui.coreUiModule
import com.example.poc.settings.featureSettingsModule
import com.rockspoon.test.data.user.TestUserRemoteDataSource
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

/**
 * A test application for instrumented tests end-to-end that overrides the coroutines
 * dispatchers.
 */
class ApplicationTest : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initDependencyInjection()

    }

    private fun initDependencyInjection() {

        startKoin {
            androidContext(this@ApplicationTest)
            modules(
                coreCommonModule(),
                coreDataModule(),
                coreDomainModule(),
                coreUiModule(),
                featureSettingsModule(),
                module {

                    // Change all the dispatchers to coroutine TestDispatcher so we can
                    // sync the interface actions and the data flow on the tests.
                    // We are giving the Main dispatcher because the TestScope do the job of calling
                    // Dispatchers.setMain(TestDispatcher()), so Dispatchers.Main becomes TestDispatcher()
                    single<CoroutineDispatcher> {
                        Dispatchers.Main
                    }

                    single<CoroutineDispatcher>(CoroutineQualifiers.IO_DISPATCHER) {
                        Dispatchers.Main
                    }

                    // Generally, you want to mock all data sources from
                    // remote servers and maybe some others.
                    factory<UserRemoteDataSource> {
                        TestUserRemoteDataSource()
                    }
                }
            )
        }

    }
}

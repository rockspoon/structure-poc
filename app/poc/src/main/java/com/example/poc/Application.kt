package com.example.poc

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.poc.core.common.coreCommonModule
import com.example.poc.core.data.coreDataModule
import com.example.poc.core.domain.coreDomainModule
import com.example.poc.core.ui.coreUiModule
import com.example.poc.settings.featureSettingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Application class override to initialize dependency injection and logger.
 */
class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()

        initDependencyInjection()

        initLogger()
    }

    private fun initDependencyInjection() {
        // Init dependency injection with Koin
        startKoin {
            androidContext(this@Application)
            modules(
                appPocModule(),
                coreCommonModule(),
                coreDataModule(),
                coreDomainModule(),
                coreUiModule(),
                featureSettingsModule()
            )
        }
    }

    private fun initLogger() {
        // Init logger with Timber
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree : Timber.Tree() {

        override fun log(
            priority: Int,
            tag: String?,
            message: String,
            t: Throwable?
        ) {
            if (priority == Log.VERBOSE || priority == Log.DEBUG) {
                return
            }
            if (t != null) {
            }
        }
    }
}
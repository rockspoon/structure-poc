package com.example.poc

import android.util.Log
import androidx.multidex.MultiDexApplication
import com.example.poc.BuildConfig
import com.example.poc.core.data.coreDataModule
import com.example.poc.core.domain.coreDomainModule
import com.example.poc.settings.featureSettingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

open class Application : MultiDexApplication() {

    override fun onCreate() {
        super.onCreate()
        initKoin()
        initLogger()
    }

    private fun initKoin() {
        // Start dependency injection
        startKoin {
            androidContext(this@Application)
            modules(
                appModule,
                coreDataModule,
                coreDomainModule,
                featureSettingsModule
            )
        }
    }

    private fun initLogger() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        } else {
            Timber.plant(CrashReportingTree())
        }
    }

    /** A tree which logs important information for crash reporting.  */
    private class CrashReportingTree() : Timber.Tree() {

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
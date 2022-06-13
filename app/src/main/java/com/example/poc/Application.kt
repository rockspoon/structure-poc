package com.example.poc

import androidx.multidex.MultiDexApplication
import com.example.core.domain.coreDomainModule
import com.example.poc.core.data.coreDataModule
import com.example.settings.featureSettingsModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class Application : MultiDexApplication() {

	override fun onCreate() {
		super.onCreate()

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
}
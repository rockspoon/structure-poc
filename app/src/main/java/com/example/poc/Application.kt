package com.example.poc

import androidx.multidex.MultiDexApplication
import com.example.poc.core.domain.coreDomainModule
import com.example.poc.core.data.coreDataModule
import com.example.poc.settings.featureSettingsModule
import kotlinx.coroutines.Dispatchers
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

open class Application : MultiDexApplication() {

	override fun onCreate() {
		super.onCreate()

		initKoin()
	}

	protected open fun initKoin(){
		// Start dependency injection
		startKoin {
			androidContext(this@Application)
			modules(moduleList)
		}
	}

	val moduleList = listOf(
		appModule,
		coreDataModule,
		coreDomainModule,
		featureSettingsModule
	)
}
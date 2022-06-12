package com.example.poc.core.data

import androidx.room.Room
import com.example.poc.core.data.preference.PreferenceDataSource
import com.example.poc.core.data.preference.PreferenceDataSourceImpl
import com.example.poc.core.data.preference.PreferenceDataSourceImpl.Companion.preferencesDataStore
import com.example.poc.core.data.user.*
import com.example.poc.datasource.database.Database
import com.example.poc.datasource.network.GitHubApiClient
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val coreDataModule = module {

    // Database
    single {
        Room.databaseBuilder(
            androidApplication().applicationContext,
            Database::class.java,
            "main"
        ).build()
    }

    // ApiClient
    single {
        GitHubApiClient()
    }

    // DataSource<Preferences>
    single<PreferenceDataSource> {
        PreferenceDataSourceImpl(
            dataStore = androidApplication().preferencesDataStore
        )
    }

    // User
    singleOf(::UserDatabaseDataSourceImpl) { bind<UserDatabaseDataSource>() }
    singleOf(::UserNetworkDataSourceImpl) { bind<UserNetworkDataSource>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }

}
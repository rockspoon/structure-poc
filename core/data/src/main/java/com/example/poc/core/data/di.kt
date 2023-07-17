package com.example.poc.core.data

import androidx.room.Room
import com.example.poc.core.common.di.CoroutineQualifiers
import com.example.poc.core.common.di.NetworkQualifiers
import com.example.poc.core.data.common.DataSourcesConfig
import com.example.poc.core.data.credentials.CredentialsLocalDataSource
import com.example.poc.core.data.credentials.CredentialsLocalDataSourceImpl
import com.example.poc.core.data.credentials.CredentialsRealmDataSource
import com.example.poc.core.data.credentials.CredentialsRealmDataSourceImpl
import com.example.poc.core.data.credentials.CredentialsRemoteDataSource
import com.example.poc.core.data.credentials.CredentialsRemoteDataSourceImpl
import com.example.poc.core.data.credentials.CredentialsRepository
import com.example.poc.core.data.order.OrderRealmDataSource
import com.example.poc.core.data.order.OrderRealmDataSourceImpl
import com.example.poc.core.data.preferences.PreferencesDataSource
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl
import com.example.poc.core.data.preferences.PreferencesDataSourceImpl.Companion.preferencesDataStore
import com.example.poc.core.data.user.UserDatabaseDataSource
import com.example.poc.core.data.user.UserDatabaseDataSourceImpl
import com.example.poc.core.data.user.UserRemoteDataSource
import com.example.poc.core.data.user.UserRemoteDataSourceImpl
import com.example.poc.core.data.user.UserRepository
import com.example.poc.core.data.user.UserRepositoryImpl
import com.example.poc.datasource.database.Database
import com.example.poc.datasource.remoteclientapi.RemoteClientApiClient
import com.example.poc.datasource.streaming_realm.RealmDatabase
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.rockspoon.merchant.datasource.datastore.credentials.CredentialsSerializer.credentialsDataStore
import com.rockspoon.merchant.datasource.rockspoon_merchant.authentication.AuthenticationApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.cash_management.CashManagementApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.catalog.CatalogApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.checkin.CheckInApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.device.DeviceApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.DineInApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.DineInCheckApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.DineInDepositApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.DineInDinerApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.dine_in.DineInItemApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.FloorPlanApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.floorplan.OrderFloorPlanApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.merchant_profile.MerchantProfileApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.orchestrator.OrchestratorApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.order.OrderApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_customer.OrderCustomerApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_item.OrderItemApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.order_receipt.OrderReceiptApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.time_clock.TimeClockApi
import com.rockspoon.merchant.datasource.rockspoon_merchant.user_profile.UserProfileV1Api
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.core.module.dsl.bind
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import retrofit2.Retrofit


fun coreDataModule() = module {

    // Database
    single {
        Room.databaseBuilder(
            androidApplication(),
            Database::class.java,
            "main"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    // ApiClient
    single {
        RemoteClientApiClient()
    }

    // DataSource<Preferences>
    single<PreferencesDataSource> {
        PreferencesDataSourceImpl(
            dataStore = androidApplication().preferencesDataStore
        )
    }

    // User
    singleOf(::UserDatabaseDataSourceImpl) { bind<UserDatabaseDataSource>() }
    singleOf(::UserRemoteDataSourceImpl) { bind<UserRemoteDataSource>() }
    singleOf(::UserRepositoryImpl) { bind<UserRepository>() }

    singleOf(::OrderRealmDataSourceImpl) { bind<OrderRealmDataSource>() }

    includes(datasourceStreamingRealmModule())
    includes(datasourceRockspoonMerchantModule())
}

fun datasourceStreamingRealmModule() = module {

    factory {
        RealmDatabase.instance
    }

}

@OptIn(ExperimentalSerializationApi::class)
fun datasourceRockspoonMerchantModule() = module {

    /**
     * A retrofit client for build RockSpoon Merchant client services
     */
    single(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT) {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        Retrofit.Builder()
            .baseUrl(get<DataSourcesConfig>().rockspoonMerchantWebServiceUrl)
            .client(client)
            .apply {
                val json = Json {
                    ignoreUnknownKeys = true
                }
                addConverterFactory(json.asConverterFactory("application/json".toMediaType()))
            }
            .build()
    }

    single<AuthenticationApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(AuthenticationApi::class.java)
    }

    single<CashManagementApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(CashManagementApi::class.java)
    }

    single<DineInApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DineInApi::class.java)
    }

    single<DineInCheckApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DineInCheckApi::class.java)
    }

    single<DineInDepositApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DineInDepositApi::class.java)
    }

    single<DineInDinerApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DineInDinerApi::class.java)
    }

    single<DineInItemApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DineInItemApi::class.java)
    }

    single<CatalogApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(CatalogApi::class.java)
    }

    single<CheckInApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(CheckInApi::class.java)
    }

    single<DeviceApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(DeviceApi::class.java)
    }

    single<MerchantProfileApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(MerchantProfileApi::class.java)
    }

    single<OrchestratorApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrchestratorApi::class.java)
    }

    single<OrderApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrderApi::class.java)
    }

    single<OrderFloorPlanApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrderFloorPlanApi::class.java)
    }

    single<FloorPlanApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(FloorPlanApi::class.java)
    }

    single<TimeClockApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(TimeClockApi::class.java)
    }

    single<UserProfileV1Api> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(UserProfileV1Api::class.java)
    }

    single<OrderReceiptApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrderReceiptApi::class.java)
    }

    single<OrderCustomerApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrderCustomerApi::class.java)
    }

    single<OrderItemApi> {
        get<Retrofit>(NetworkQualifiers.ROCKSPOON_MERCHANT_CLIENT_RETROFIT)
            .create(OrderItemApi::class.java)
    }

    single {
        CredentialsRepository(
            credentialsRemoteDataSource = get(),
            credentialsLocalDataSource = get(),
            credentialsRealmDataSource = get(),
            externalScope = get(CoroutineQualifiers.APPLICATION_SCOPE)
        )
    }

    singleOf(::CredentialsRemoteDataSourceImpl) {
        bind<CredentialsRemoteDataSource>()
    }
    singleOf(::CredentialsLocalDataSourceImpl) {
        bind<CredentialsLocalDataSource>()
    }
    singleOf(::CredentialsRealmDataSourceImpl) {
        bind<CredentialsRealmDataSource>()
    }

    single {
        androidApplication().credentialsDataStore
    }

}
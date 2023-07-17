package com.example.poc

import com.example.poc.core.common.di.NetworkQualifiers
import com.example.poc.core.data.common.DataSourcesConfig
import com.example.poc.ui.main.AppPocEventDelegate
import com.example.poc.ui.main.AppPocEventDelegateImpl
import com.example.poc.ui.main.FeatureAuthEventDelegate
import com.example.poc.ui.main.FeatureAuthEventDelegateImpl
import com.example.poc.ui.main.FeatureSearchEventDelegate
import com.example.poc.ui.main.FeatureSearchEventDelegateImpl
import com.example.poc.ui.main.FeatureSettingsEventDelegate
import com.example.poc.ui.main.FeatureSettingsEventDelegateImpl
import com.example.poc.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

private const val DEFAULT_HTTP_REQUEST_READ_TIMEOUT_MILLISECONDS = 3_500L
private const val DEFAULT_HTTP_REQUEST_WRITE_TIMEOUT_MILLISECONDS = 3_500L
private const val DEFAULT_HTTP_REQUEST_CONNECTION_TIMEOUT_MILLISECONDS = 3_500L


object ApiUrl {
    const val prod = "https://api.prod.rockspoon.io/"
    const val uat = "https://api.uat.rockspoon.io/"
    const val staging = "https://api.stg.rockspoon.io/"
    const val dev = "https://dev-api.rockspoon.io/"
}

fun appPocModule() = module {

    single {
        DataSourcesConfig(
            rockspoonMerchantWebServiceUrl = "https://api.stg.rockspoon.io/",
            rockspoonPaymentWebServiceUrl = "https://stg-pay.rockspoon.io/"
        )
    }

    /** network **/

    // For testing for example, you can easily replace these values by overriding it
    // without need to replace the OKHttpClient. See Koin documentation.
    single(NetworkQualifiers.REQUEST_READ_TIMEOUT_MILLISECONDS) {
        DEFAULT_HTTP_REQUEST_READ_TIMEOUT_MILLISECONDS
    }

    single(NetworkQualifiers.REQUEST_WRITE_TIMEOUT_MILLISECONDS) {
        DEFAULT_HTTP_REQUEST_WRITE_TIMEOUT_MILLISECONDS
    }

    single(NetworkQualifiers.REQUEST_CONNECTION_TIMEOUT_MILLISECONDS) {
        DEFAULT_HTTP_REQUEST_CONNECTION_TIMEOUT_MILLISECONDS
    }

    factoryOf<AppPocEventDelegate>(::AppPocEventDelegateImpl)

    factoryOf<FeatureAuthEventDelegate>(::FeatureAuthEventDelegateImpl)

    factoryOf<FeatureSearchEventDelegate>(::FeatureSearchEventDelegateImpl)

    factoryOf<FeatureSettingsEventDelegate>(::FeatureSettingsEventDelegateImpl)

    viewModelOf(::MainViewModel)

}
package com.example.poc.core.data.common

// This is today being delivered by dependency injection but should be "harded code" because
// it's one of the things that can't change on Android
// See https://android-developers.googleblog.com/2011/06/things-that-cannot-change.html.
// Keep this being delivered by dependency injection + BuildConfig incentives the developers
// do not pay attention that they can't change the setup app package. Best practice is to deal
// with it in the same way that we would deal with external to the company app content providers,
// assume constant and from the setup app perspective assume that you can't change.
// For testability, mocking the data source that provides setup app configuration must be enough.
data class DataSourcesConfig(
	val rockspoonMerchantWebServiceUrl: String,
	val rockspoonPaymentWebServiceUrl: String
)

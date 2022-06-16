import org.jetbrains.kotlin.fir.types.builder.buildDynamicTypeRef

plugins {
	id("com.android.application")
	id("org.jetbrains.kotlin.android")
}

android {

	compileSdk = 32

	defaultConfig {
		applicationId = "com.example.poc"
		minSdk = 23
		targetSdk = 32
		versionCode = 1
		versionName = "1.0"
		multiDexEnabled = true

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release {
			isMinifyEnabled = false
			proguardFiles(
				getDefaultProguardFile("proguard-android-optimize.txt"),
				"proguard-rules.pro"
			)
		}
		create("benchmark") {
			signingConfig = signingConfigs.getByName("debug")
			matchingFallbacks += listOf("release")
			isDebuggable = false
		}
	}

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = "1.8"
	}

	setDynamicFeatures(
		setOf(
			":feature_auth",
			":feature_home",
			":feature_search"
		)
	)

	buildFeatures {
		viewBinding = true
	}

	testOptions {
		animationsDisabled = true
	}
    dynamicFeatures += setOf(":feature_server")
}

dependencies {

	api(project(":core_data"))
	api(project(":core_domain"))
	api(project(":core_provider"))
	api(project(":core_receiver"))
	api(project(":core_service"))
	api(project(":core_ui"))
	implementation(project(":feature_settings"))


	// TODO put it as implementation and put in feature modules
	api("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
	api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
	androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")

	implementation("androidx.multidex:multidex:2.0.1")

	// DI
	api("io.insert-koin:koin-android:3.2.0")
	testImplementation("io.insert-koin:koin-test:3.2.0")
	testImplementation("io.insert-koin:koin-test-junit4:3.2.0")

	implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.0-rc01")
	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	// Keep this also here otherwise instrumentedTests in feature modules will miss the
	// style/FragmentScenarioEmptyFragmentActivityTheme in the manifest.
	debugImplementation("androidx.fragment:fragment-testing:1.4.1")

	androidTestImplementation("androidx.test:core-ktx:1.4.0")
	androidTestImplementation("androidx.test:runner:1.4.0")
	androidTestImplementation("androidx.test:rules:1.4.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")

	// Put the feature as dependencies of androidTest so we can use the IDs with Expresso
	androidTestImplementation(project(":feature_auth"))
	androidTestImplementation(project(":feature_home"))
	androidTestImplementation(project(":feature_search"))
	androidTestImplementation(project(":core_data"))

}
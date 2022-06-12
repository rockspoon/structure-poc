plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {

	compileSdk = 32

	defaultConfig {
		minSdk = 19
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
	}
}

dependencies {

	implementation(project(":core_data"))
	implementation(project(":core_ui"))

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

	// DI
	api("io.insert-koin:koin-android:3.2.0")
	testImplementation("io.insert-koin:koin-test:3.2.0")
	testImplementation("io.insert-koin:koin-test-junit4:3.2.0")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
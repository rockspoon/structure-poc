plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

android {

	compileSdk = 32

	defaultConfig {
		minSdk = 23
		targetSdk = 32

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")
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

	compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	}

	kotlinOptions {
		jvmTarget = "1.8"
	}
}

dependencies {

	implementation(project(":core:common"))
	implementation(project(":datasource:database"))
	implementation(project(":datasource:remote_client"))
	implementation(project(":datasource:local_client"))
    // Notice that we use implementation rather than api, so databases classes can't be accessed
	// by any other module.

    implementation("androidx.datastore:datastore:1.0.0")
	implementation("androidx.datastore:datastore-preferences:1.0.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

	// DI
	implementation("io.insert-koin:koin-android:3.2.0")
	testImplementation("io.insert-koin:koin-test:3.2.0")
	testImplementation("io.insert-koin:koin-test-junit4:3.2.0")

	implementation("androidx.core:core-ktx:1.8.0")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
plugins {
	id("com.android.dynamic-feature")
	id("org.jetbrains.kotlin.android")
}

android {

	compileSdk = 32

	defaultConfig {
		minSdk = 23
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		release{
			isMinifyEnabled = false
			proguardFiles(
					getDefaultProguardFile("proguard-android-optimize.txt"),
					"proguard-rules.pro"
			)
		}
	}
}

dependencies {

	implementation(project(":app:poc"))
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")


	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
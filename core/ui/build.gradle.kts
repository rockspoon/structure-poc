plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
	from("${project.rootDir}/script-viewbinding.gradle")
}

android {

	defaultConfig {
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
}

dependencies {

	implementation(project(":core:common"))
	implementation("androidx.core:core-ktx:1.8.0")

	api("androidx.compose.ui:ui:1.4.1")
	api("androidx.navigation:navigation-compose:2.5.3")
	api("androidx.compose.ui:ui-tooling-preview:1.4.1")
	api("androidx.compose.material3:material3:1.1.0-beta02")
	api("androidx.appcompat:appcompat:1.5.0")
	api("com.google.android.material:material:1.6.1")
	api("androidx.constraintlayout:constraintlayout:2.1.4")
	api("androidx.navigation:navigation-fragment-ktx:2.5.3")
	api("androidx.navigation:navigation-ui-ktx:2.5.3")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")

	debugApi("androidx.compose.ui:ui-tooling:1.4.1")
}
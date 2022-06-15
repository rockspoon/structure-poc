import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
	kotlin("kapt")
}

android {
	compileSdk = 32

	defaultConfig {
		minSdk = 23
		targetSdk = 32

		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
		consumerProguardFiles("consumer-rules.pro")

		javaCompileOptions {
			annotationProcessorOptions {
				arguments += mapOf(
					"room.schemaLocation" to "$projectDir/schemas",
					"room.incremental" to "true",
					"room.expandProjection" to "true"
				)
			}
		}
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

	implementation("androidx.core:core-ktx:1.7.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")

	val roomVersion = "2.4.2"
	api("androidx.room:room-runtime:$roomVersion")
	annotationProcessor("androidx.room:room-compiler:$roomVersion")
	kapt("androidx.room:room-compiler:$roomVersion")
	// To use Kotlin Symbolic Processing (KSP)
	//ksp("androidx.room:room-compiler:$roomVersion")
	api("androidx.room:room-ktx:$roomVersion")
	testImplementation("androidx.room:room-testing:$roomVersion")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
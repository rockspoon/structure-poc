plugins {
	id("com.android.dynamic-feature")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
	from("${project.rootDir}/script-viewbinding.gradle")
}

android {
	
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
	implementation(project(":app:poc"))
	implementation(project(":core:common"))
	implementation(project(":core:data"))
	implementation(project(":core:domain"))
	implementation(project(":core:ui"))
	implementation("io.realm.kotlin:library-sync:1.8.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
}
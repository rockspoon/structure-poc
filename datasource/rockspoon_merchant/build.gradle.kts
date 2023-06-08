plugins {
	id("com.android.library")
	id("kotlin-android")
	id("kotlinx-serialization")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
}

dependencies {
	implementation(project(":core:common"))

	implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")

	api("com.squareup.retrofit2:retrofit:2.9.0")
}
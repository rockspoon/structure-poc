plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
}

dependencies {

	implementation("androidx.core:core-ktx:1.7.0")
	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
	api("com.squareup.retrofit:retrofit:2.0.0-beta2")

	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
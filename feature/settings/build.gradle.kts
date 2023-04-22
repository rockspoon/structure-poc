plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
	from("${project.rootDir}/script-viewbinding.gradle")
}

dependencies {

	implementation(project(":core:common"))
	implementation(project(":core:data"))
	implementation(project(":core:domain"))
	implementation(project(":core:ui"))

	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

	// DI
	api("io.insert-koin:koin-android:3.2.0")
	testImplementation("io.insert-koin:koin-test:3.2.0")
	testImplementation("io.insert-koin:koin-test-jvm:3.2.0")
	testImplementation("io.insert-koin:koin-test-junit4:3.2.0")

	// Needs both otherwise the test will miss the style/FragmentScenarioEmptyFragmentActivityTheme
	debugImplementation("androidx.fragment:fragment-testing:1.4.1")

	testImplementation("junit:junit:4.13.2")

	androidTestImplementation("androidx.test:core-ktx:1.4.0")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
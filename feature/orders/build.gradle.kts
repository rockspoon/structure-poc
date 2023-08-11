plugins {
	id("com.android.library")
	id("org.jetbrains.kotlin.android")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
	from("${project.rootDir}/script-compose.gradle")
}

dependencies {

	implementation(project(":core:common"))
	implementation(project(":core:data"))
	implementation(project(":core:domain"))
	implementation(project(":core:ui"))
	implementation(project(":datasource:streaming_realm"))

	runtimeOnly("io.insert-koin:koin-androidx-compose:3.4.4")


	implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")


	testImplementation("junit:junit:4.13.2")
	androidTestImplementation("androidx.test.ext:junit:1.1.3")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
	androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
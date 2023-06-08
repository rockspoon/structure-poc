plugins {
	id("com.android.library")
	id("kotlin-android")
	id("com.google.protobuf")
}

apply {
	from("${project.rootDir}/script-android-version.gradle")
	from("${project.rootDir}/script-protobuf.gradle")
}

dependencies {
	implementation(project(":core:common"))

	api("androidx.datastore:datastore-preferences:1.0.0")
	// Both libraries are necessary to their dependants to work with their class types
	api("androidx.datastore:datastore:1.0.0")
	// We use the java instead of kotlin because I couldn't make it work with Kotlin yet when
	// using the Kotlin DSL gradle, when Kotlin DSL becomes stable, I'll try again.
	api("io.grpc:grpc-protobuf-lite:1.46.0")

	testImplementation(project(":test:common"))
}
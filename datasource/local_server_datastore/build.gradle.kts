plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
    // TODO The Kotlin DSL for proto buffers is not working well, so we import the Groovy version.
//      Change later when Kotlin DSL for proto buffers leaves the beta.
    from("${project.rootDir}/script-protobuf.gradle")
}

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")

    // Both libraries are necessary to their dependants to work with their class types
    api("androidx.datastore:datastore:1.0.0")
    // We use the java instead of kotlin because I couldn't make it work with Kotlin yet when
    // using the Kotlin DSL gradle, when Kotlin DSL becomes stable, I'll try again.
    api("com.google.protobuf:protobuf-javalite:3.21.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.work:work-runtime-ktx:2.7.1")
}

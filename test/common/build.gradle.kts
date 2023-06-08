plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
}

dependencies {

    implementation(project(":core:ui"))

    api("org.jetbrains.kotlin:kotlin-test-junit:1.8.10")
    api("org.mockito:mockito-core:3.12.4")
    api("com.nhaarman:mockito-kotlin-kt1.1:1.6.0")
    api("io.mockk:mockk:1.12.3")
    api("org.jetbrains.kotlin:kotlin-test-junit:1.8.10")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    api("androidx.test.espresso:espresso-core:3.5.1")
    api("androidx.test.espresso:espresso-contrib:3.5.0") {
        exclude("protobuf-lite")
    }
    api("org.mockito:mockito-android:3.12.4")
}

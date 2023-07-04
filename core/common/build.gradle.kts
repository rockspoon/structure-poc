plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
}

dependencies {
    api("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    api("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")

    // DI
    api("javax.inject:javax.inject:1")
    api("io.insert-koin:koin-android:3.4.0")
    api("io.insert-koin:koin-androidx-compose:3.4.4")
    api("com.jakewharton.timber:timber:5.0.1")
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")

    api("androidx.paging:paging-compose:1.0.0-alpha18")

    testApi("io.insert-koin:koin-test:3.4.0")
    testApi("io.insert-koin:koin-test-junit4:3.4.0")
    
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}
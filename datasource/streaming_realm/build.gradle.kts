plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.kapt")
    id("io.realm.kotlin")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
    from("${project.rootDir}/script-viewbinding.gradle")
}

//realm {
//	isSyncEnabled = true
//}

dependencies {

    implementation(project(":core:common"))

    api("io.realm.kotlin:library-sync:1.8.0")
    
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}
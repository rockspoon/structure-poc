plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
}

dependencies {

    implementation(project(":app:poc"))
    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))

    implementation("androidx.localbroadcastmanager:localbroadcastmanager:1.1.0")

    implementation("androidx.core:core-ktx:1.7.0")
    testImplementation("junit:junit:4.13.2")

    implementation("androidx.work:work-runtime-ktx:2.7.1")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
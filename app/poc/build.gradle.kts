plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    //id("dagger.hilt.android.plugin")
}

apply {
    from("${project.rootDir}/script-android-version.gradle")
}

android {

    defaultConfig {
        applicationId = "com.example.poc"
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true
        testInstrumentationRunner = "com.example.poc.ApplicationTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            //isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "benchmark-rules.pro"
            )
        }
    }

    setDynamicFeatures(
        setOf(
            ":feature:auth",
            ":feature:home",
            ":feature:search",
            ":feature:local_client",
            ":feature:local_server"
        )
    )

    buildFeatures {
        viewBinding = true
    }

    testOptions {
        animationsDisabled = true
    }
}

// Allow references to generated code
//kapt {
//	correctErrorTypes = true
//}

dependencies {

    implementation(project(":core:common"))
    implementation(project(":core:data"))
    implementation(project(":core:domain"))
    implementation(project(":core:service"))
    implementation(project(":core:ui"))
    implementation(project(":feature:settings"))

    api("androidx.datastore:datastore:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.21.2")

    // TODO put it as implementation and put in feature modules
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.5.1")

    // Work runtime need to be here in :app module. It can't be just in the feature module.
    // See: https://stackoverflow.com/questions/51353180/android-resource-linking-failed-due-to-missing-boolean-resource-values-using-jet
    api("androidx.work:work-runtime-ktx:2.7.1")

    api("androidx.work:work-runtime-ktx:2.7.1")

    implementation("androidx.datastore:datastore:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")

    implementation("androidx.multidex:multidex:2.0.1")

    api("io.ktor:ktor-server-core:2.0.2")
    api("io.ktor:ktor-server-netty:2.0.2")
    api("io.ktor:ktor-server-content-negotiation:2.0.2")
    api("io.ktor:ktor-serialization-kotlinx-json:2.0.2")

    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.1")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    // Keep this also here otherwise instrumentedTests in feature modules will miss the
    // style/FragmentScenarioEmptyFragmentActivityTheme in the manifest.
    debugImplementation("androidx.fragment:fragment-testing:1.5.2")
    implementation("androidx.test:runner:1.4.0")

    androidTestImplementation(project(":test:data"))
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation(project(":feature:auth"))
    androidTestImplementation(project(":feature:home"))
    androidTestImplementation(project(":feature:search"))

    // Put the module as dependencies of androidTest so we can use the IDs with Expresso
    androidTestImplementation(project(":core:data"))
}
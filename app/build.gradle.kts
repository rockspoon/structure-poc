import com.google.protobuf.gradle.protobuf
import com.google.protobuf.gradle.protoc

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
//    id("dagger.hilt.android.plugin")
}

android {

    compileSdk = 32

    defaultConfig {
        applicationId = "com.example.poc"
        minSdk = 23
        targetSdk = 32
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = true

        testInstrumentationRunner = "com.example.poc.ApplicationTestRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        create("benchmark") {
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks += listOf("release")
            isDebuggable = false
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    setDynamicFeatures(
        setOf(
            ":feature_auth",
            ":feature_client",
            ":feature_home",
            ":feature_search",
            ":feature_server"
        )
    )

    buildFeatures {
        viewBinding = true
    }

    testOptions {
        animationsDisabled = true
    }

    packagingOptions {
        resources {
            resources.excludes.add("META-INF/*")
        }
    }
}

// Allow references to generated code
//kapt {
//	correctErrorTypes = true
//}

dependencies {

    api(project(":core_data"))
    api(project(":core_domain"))
    api(project(":core_service"))
    api(project(":core_ui"))
    implementation(project(":feature_settings"))

    api("androidx.datastore:datastore:1.0.0")
    implementation("com.google.protobuf:protobuf-javalite:3.21.2")

    // TODO put it as implementation and put in feature modules
    api("androidx.lifecycle:lifecycle-livedata-ktx:2.4.1")
    api("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.1")

    // Work runtime need to be here in :app module. It can't be just in the feature module.
    // See: https://stackoverflow.com/questions/51353180/android-resource-linking-failed-due-to-missing-boolean-resource-values-using-jet
    api("androidx.work:work-runtime-ktx:2.7.1")

    implementation("androidx.datastore:datastore:1.0.0")

    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.2")
    androidTestImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.2")

    implementation("androidx.multidex:multidex:2.0.1")

    // DI
//    api("com.google.dagger:hilt-android:2.40.5")
//    kapt("com.google.dagger:hilt-android-compiler:2.40.5")
    api("javax.inject:javax.inject:1")
    api("io.insert-koin:koin-android:3.2.0")
    testImplementation("io.insert-koin:koin-test:3.2.0")
    testImplementation("io.insert-koin:koin-test-junit4:3.2.0")

    implementation("androidx.navigation:navigation-dynamic-features-fragment:2.5.0-rc02")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    // Keep this also here otherwise instrumentedTests in feature modules will miss the
    // style/FragmentScenarioEmptyFragmentActivityTheme in the manifest.
    debugImplementation("androidx.fragment:fragment-testing:1.4.1")

    implementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:core-ktx:1.4.0")
    androidTestImplementation("androidx.test:runner:1.4.0")
    androidTestImplementation("androidx.test:rules:1.4.0")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")

    // Put the feature as dependencies of androidTest so we can use the IDs with Expresso
    androidTestImplementation(project(":feature_auth"))
    androidTestImplementation(project(":feature_home"))
    androidTestImplementation(project(":feature_search"))
    androidTestImplementation(project(":core_data"))
}
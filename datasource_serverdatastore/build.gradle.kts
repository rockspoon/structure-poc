plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("com.google.protobuf")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        targetSdk = 32

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

// TODO The Kotlin DSL for proto buffers is not working well, so we import the Groovy version.
//      Change later when Kotlin DSL for proto buffers leaves the beta.
apply(from = "${project.rootDir}/datasource_serverdatastore/protobuf.gradle")

dependencies {

    implementation("androidx.core:core-ktx:1.7.0")

    // Both libraries are necessary to their dependants to work with their class types
    api("androidx.datastore:datastore:1.0.0")
    api("com.google.protobuf:protobuf-javalite:3.21.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.work:work-runtime-ktx:2.7.1")
}

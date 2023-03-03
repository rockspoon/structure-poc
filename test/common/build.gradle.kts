plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
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

dependencies {

    implementation(":core:ui")

    api("org.mockito:mockito-core:3.12.4")
    api("com.nhaarman:mockito-kotlin-kt1.1:1.6.0")
    api("io.mockk:mockk:1.12.3")
    api("junit:junit:4.13.2")
    api("org.jetbrains.kotlin:kotlin-test-junit:1.7.21")
    api("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.6.4")
    api("androidx.test.espresso:espresso-core:3.5.1")
    api("androidx.test.espresso:espresso-contrib:1.0.0") {
        exclude("protobuf-lite")
    }
    api("org.mockito:mockito-android:3.12.4")
}

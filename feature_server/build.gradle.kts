plugins {
    id("com.android.dynamic-feature")
    id("org.jetbrains.kotlin.android")
}
android {
    compileSdk = 32

    defaultConfig {
        minSdk = 23
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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

    packagingOptions {
        resources {
            resources.excludes.add("META-INF/*")
        }
    }
}

dependencies {
    implementation(project(":app"))
    implementation(project(":datasource_serverdatabase"))
    implementation(project(":datasource_serverdatastore"))

    implementation("androidx.core:core-ktx:1.7.0")
    testImplementation("junit:junit:4.13.2")

    implementation("androidx.work:work-runtime-ktx:2.7.1")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
    androidTestImplementation("androidx.annotation:annotation:1.3.0")
}
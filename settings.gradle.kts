pluginManagement {

    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "com.google.protobuf" -> {
                    useModule("com.google.protobuf:protobuf-gradle-plugin:${requested.version}")
                }
                "dagger.hilt.android.plugin" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:${requested.version}")
                }
                "realm-android" -> {
                    useModule("io.realm:realm-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}

plugins {
    id("org.jetbrains.kotlin.android") version "1.8.10" apply false
    id("org.jetbrains.kotlin.plugin.serialization") version "1.8.10" apply false
    id("com.google.devtools.ksp") version "1.8.10-1.0.9" apply false
    id("org.jetbrains.kotlin.kapt") version "1.8.10" apply false
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("com.android.dynamic-feature") version "7.2.2" apply false
    id("com.android.test") version "7.2.2" apply false
    id("androidx.benchmark") version "1.2.0-alpha01" apply false
    id("com.google.protobuf") version "0.8.17" apply false
    id("io.realm.kotlin") version "1.8.0" apply false
    //id("dagger.hilt.android.plugin") version "2.40.5" apply false
}

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
        mavenLocal()
    }
}

rootProject.name = "PoC"

include(":app:poc")
include(":core:common")
include(":core:data")
include(":core:domain")
include(":core:service")
include(":core:ui")
include(":datasource:database")
include(":datasource:datastore")
include(":datasource:local_client")
include(":datasource:local_server_database")
include(":datasource:local_server_datastore")
include(":datasource:remote_client")
include(":datasource:rockspoon_merchant")
include(":datasource:streaming_realm")
include(":feature:auth")
include(":feature:auth_pin_code")
include(":feature:home")
include(":feature:local_client")
include(":feature:local_server")
include(":feature:search")
include(":feature:settings")
include(":test:common")
include(":test:data")
include(":test:macrobenchmark")
include(":test:microbenchmark")
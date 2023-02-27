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
            }
        }
    }
}

plugins {
    id("com.android.application") version "7.2.2" apply false
    id("com.android.library") version "7.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.7.0" apply false
    id("com.android.dynamic-feature") version "7.2.2" apply false
    id("com.android.test") version "7.2.2" apply false
    id("androidx.benchmark") version "1.2.0-alpha01" apply false
    id("com.google.devtools.ksp") version "1.7.0-1.0.6" apply false
    id("com.google.protobuf") version "0.8.17" apply false
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
include(":datasource:local_client")
include(":datasource:local_server_database")
include(":datasource:local_server_datastore")
include(":datasource:remote_client")
include(":feature:auth")
include(":feature:home")
include(":feature:local_client")
include(":feature:local_server")
include(":feature:search")
include(":feature:settings")
include(":test:common")
include(":test:data")
include(":test:macrobenchmark")
include(":test:microbenchmark")
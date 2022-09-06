pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }

    resolutionStrategy {
        eachPlugin {
            when (requested.id.id) {
                "dagger.hilt.android.plugin" -> {
                    useModule("com.google.dagger:hilt-android-gradle-plugin:${requested.version}")
                }
                "com.google.protobuf" -> {
                    useModule("com.google.protobuf:protobuf-gradle-plugin:${requested.version}")
                }
            }
        }
    }
}

dependencyResolutionManagement {

    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        google()
        maven(url = "https://jitpack.io")
        mavenCentral()
        mavenLocal()
    }
}

rootProject.name = "PoC"

include(":app")
include(":core_data")
include(":core_domain")
include(":core_service")
include(":core_ui")
include(":feature_auth")
include(":feature_localclient")
include(":feature_home")
include(":feature_localserver")
include(":feature_search")
include(":feature_settings")
include(":datasource_database")
include(":datasource_localclient")
include(":datasource_localserverdatabase")
include(":datasource_localserverdatastore")
include(":datasource_remoteclient")
include(":macrobenchmark")
include(":microbenchmark")

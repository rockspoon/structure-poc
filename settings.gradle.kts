pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
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
include(":feature_auth")
include(":feature_home")
include(":feature_search")
include(":feature_settings")
include(":core_data")
include(":core_domain")
include(":core_provider")
include(":core_receiver")
include(":core_service")
include(":core_ui")
include(":datasource_database")
include(":macrobenchmark")
include(":microbenchmark")
include(":datasource_network")

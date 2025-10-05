pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Run-Tracker-App"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
include(":app")
include(":auth")
include(":auth:data")
include(":auth:domain")
include(":auth:presentation")
include(":core")
include(":core:data")
include(":core:domain")
include(":core:presentation")
include(":core:presentation:designsystem")
include(":core:presentation:ui")
include(":network")
include(":core:database")
include(":run")
include(":run:data")
include(":run:domain")
include(":run:presentation")

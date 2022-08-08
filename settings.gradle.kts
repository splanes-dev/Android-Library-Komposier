enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
enableFeaturePreview("VERSION_CATALOGS")

pluginManagement {
    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        register("libs")
    }
    repositories {
        google()
        mavenCentral()
    }
}

include(":app")

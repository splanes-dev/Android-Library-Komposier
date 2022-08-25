// Remove `@file:Suppress("UnstableApiUsage")` once Version Catalogs has had released as @Stable
@file:Suppress("UnstableApiUsage")

enableFeaturePreview("VERSION_CATALOGS")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    versionCatalogs {
        create("baseLibs") {
            from(files("gradle/base.libs.versions.toml"))
        }
    }
    repositories {
        google()
        mavenCentral()
        maven(url = "https://jitpack.io")
    }
}

rootProject.name = "Komposier"
include(":app")
include(":ui:theme")
include(":ui:toolkit")
include(":component-catalog:snackbar")
include(":component-catalog:buttons-extension")
include(":component-catalog:dialogs-extension")
include(":commons")

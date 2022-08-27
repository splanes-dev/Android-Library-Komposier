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

apply(from = "gradle/dependency-catalogs.settings.gradle.kts")

rootProject.name = "Komposier"
include(":app")
include(":commons")
include(":ui:theme")
include(":ui:toolkit")
include(":component-catalog:snackbar")
include(":component-catalog:buttons-extension")
include(":component-catalog:dialogs-extension")
include(":component-catalog:lottie-animations-extension")
include(":component-catalog:forms:core")

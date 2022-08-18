// TODO: Remove `@file:Suppress("UnstableApiUsage")` once Version Catalogs has had released as @Stable
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
    }
}

rootProject.name = "Komposier"
include(":app")
include(":ui-theme")
include(":component-catalog:snackbar")
include(":component-catalog:button")
include(":commons")

@file:Suppress("UnstableApiUsage")

buildscript {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.13")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.7.10")
    }

    onEachModule {
        androidLibs.plugins.android.run {
            when (type) {
                ProjectType.Application -> application
                ProjectType.Library -> library
            }
        }.let { provider -> apply(provider = provider) }
        apply(provider = baseLibs.plugins.kotlin.android)
        apply(provider = baseLibs.plugins.kotlin.kapt)
        apply(provider = baseLibs.plugins.kotlin.parcelize)

        androidConfig {
            compileSdkVersion(32)
            defaultConfig {
                minSdk = 28
                compileSdkVersion(32)
                testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                vectorDrawables { useSupportLibrary = true }
                consumerProguardFiles("consumer-rules.pro")
            }
            compileOptions {
                sourceCompatibility = JavaVersion.VERSION_11
                targetCompatibility = JavaVersion.VERSION_11
            }
        }

        dependencies {
            implementation(baseLibs.bundles.core)
            implementation(androidLibs.bundles.core)
            kapt(androidLibs.hilt.compiler)
            implementation(androidLibs.bundles.hilt)

            testImplementation(testLibs.bundles.test.unit)
            androidTestImplementation(testLibs.bundles.test.instrumental)
        }
    }
}

buildscript {

    repositories {
        mavenCentral()
        google()
        gradlePluginPortal()
        maven(url = "https://plugins.gradle.org/m2/")
    }

    dependencies {
        classpath("com.google.gms:google-services:4.3.13")
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.40.5")
    }

    onEachModule {
        baseLibs.plugins.android.run {
            when (type) {
                ProjectType.Application -> application
                ProjectType.Library -> library
            }
        }.let { provider -> apply(provider = provider) }
        apply(provider = baseLibs.plugins.kotlin.android)
        apply(provider = baseLibs.plugins.kotlin.kapt)
        apply(provider = baseLibs.plugins.kotlin.parcelize)

        dependencies {
            implementation(baseLibs.bundles.core.asProvider())
            kapt(baseLibs.hilt.compiler)
            implementation(baseLibs.bundles.hilt)

            testImplementation(baseLibs.bundles.core.test.asProvider())
            androidTestImplementation(baseLibs.bundles.core.test.android)
        }
    }
}

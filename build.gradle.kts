@file:Suppress("UnstableApiUsage")

buildscript {
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
        apply(provider = baseLibs.plugins.detekt)

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

        val detekt = tasks.register<io.gitlab.arturbosch.detekt.Detekt>("custom_detekt") {
            description = "Runs a custom detekt build."
            setSource(files("src/main/java"))
            config.setFrom(files("$rootDir/detekt/detekt-config.yml"))
            jvmTarget = "11"
            reports {
                xml.required.set(true)
                html.required.set(true)
                txt.required.set(true)
                sarif.required.set(true)
                md.required.set(true)
            }
            buildUponDefaultConfig = true
            debug = true
            include("**/*.kt")
            include("**/*.kts")
            exclude("resources/")
            exclude("build/")
        }

        tasks.named("check") {
            dependsOn(detekt)
        }

        dependencies {
            implementation(baseLibs.bundles.core)
            implementation(androidLibs.bundles.core)
            kapt(androidLibs.android.dagger.hilt.compiler)
            implementation(androidLibs.bundles.hilt)

            testImplementation(testLibs.bundles.core.unit)
            androidTestImplementation(testLibs.bundles.core.instrumental)
        }
    }
}

@file:Suppress("UnstableApiUsage")

android {
    namespace = "com.splanes.komposier.uitheme"
    compileSdk = 32
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.0-beta01"
    }
}

dependencies {
    api(projects.commons)
    api(baseLibs.bundles.compose)
}
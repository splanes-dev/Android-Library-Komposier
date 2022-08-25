@file:Suppress("UnstableApiUsage")

android {
    namespace = "com.splanes.komposier.commons"
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

    implementation(androidLibs.bundles.compose)
    implementation(androidLibs.android.lifecycle)

    testImplementation(testLibs.bundles.test.unit)
    androidTestImplementation(testLibs.bundles.test.instrumental)

    // TODO: Refactor to handle dependencies with VersionCatalogs
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.1")
}

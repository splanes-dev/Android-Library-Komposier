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

    implementation(baseLibs.bundles.compose)
    implementation(baseLibs.android.lifecycle)

    testImplementation(baseLibs.bundles.core.test)
    androidTestImplementation(baseLibs.bundles.core.test.android)

    // TODO: Refactor to handle dependencies with VersionCatalogs
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.2.1")
    debugImplementation("androidx.compose.ui:ui-tooling:1.2.1")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.2.1")
}
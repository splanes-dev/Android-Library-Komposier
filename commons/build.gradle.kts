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

    testImplementation(testLibs.bundles.core.unit)
    androidTestImplementation(testLibs.bundles.core.instrumental)
    androidTestImplementation(testLibs.compose.instrumental)

    debugImplementation(testLibs.bundles.compose.debug)
}

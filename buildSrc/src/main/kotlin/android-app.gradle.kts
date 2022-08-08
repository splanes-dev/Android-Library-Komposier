plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    //alias(coreLibs.plugins.detekt)
}

android {
    compileSdk = project.extra["sdkCompileVersion"].toString().toInt()
    defaultConfig {
        applicationId = project.extra["applicationId"].toString()
        minSdk = project.extra["sdkMinVersion"].toString().toInt()
        targetSdk = project.extra["sdkTargetVersion"].toString().toInt()
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
        freeCompilerArgs = listOf("-opt-in=kotlin.RequiresOptIn")
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

//detekt {
//    buildUponDefaultConfig = true // preconfigure defaults
//    allRules = false // activate all available (even unstable) rules.
//    config =
//        files("$projectDir/detekt-config.yml") // point to your custom config defining rules to run, overwriting default behavior
//    baseline =
//        file("$projectDir/detekt-baseline.xml") // a way of suppressing issues before introducing detekt
//}
//
//tasks.withType<Detekt>().configureEach {
//    reports {
//        html.required.set(true) // observe findings in your browser with structure and code snippets
//        xml.required.set(true) // checkstyle like format mainly for integrations like Jenkins
//        txt.required.set(true) // similar to the console output, contains issue signature to manually edit baseline files
//        sarif.required.set(true) // standardized SARIF format (https://sarifweb.azurewebsites.net/) to support integrations with Github Code Scanning
//        md.required.set(true) // simple Markdown format
//    }
//}
//
//tasks.withType<Detekt>().configureEach {
//    jvmTarget = "1.8"
//}
//tasks.withType<DetektCreateBaselineTask>().configureEach {
//    jvmTarget = "1.8"
//}

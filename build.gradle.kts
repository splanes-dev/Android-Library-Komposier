buildscript {
    subprojects {

        if (isApp) {
            apply(provider = libs.plugins.android.application)
        } else {
            apply(provider = libs.plugins.android.library)
        }
        apply(provider = libs.plugins.kotlin.android)
        apply(provider = libs.plugins.kotlin.kapt)
        apply(provider = libs.plugins.kotlin.parcelize)
        apply(provider = libs.plugins.hilt)
        // apply(provider = libs.plugins.dokka)
        // apply(provider = libs.plugins.changelog)
        // apply(provider = libs.plugins.detekt)

        dependencies {
            "implementation"(libs.bundles.base.libs)
            "kapt"(libs.hilt.compiler)
            "implementation"(libs.bundles.hilt)

            "testImplementation"(libs.bundles.base.test)
            "androidTestImplementation"(libs.bundles.base.test.android)
        }
    }
}

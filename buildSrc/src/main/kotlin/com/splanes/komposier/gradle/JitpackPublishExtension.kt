package com.splanes.komposier.gradle

import org.gradle.api.provider.Property

interface JitpackPublishExtension {
    val group: Property<String>
    val id: Property<String>
    val version: Property<String>
}
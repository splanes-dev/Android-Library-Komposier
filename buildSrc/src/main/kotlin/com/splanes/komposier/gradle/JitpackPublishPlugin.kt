package com.splanes.komposier.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project

class JitpackPublishPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        if (!target.plugins.hasPlugin(MavenPublish)) {
            target.plugins.apply(MavenPublish)
        }

        val configuration = target.extensions.create("${this::class.simpleName}Configuration", JitpackPublishExtension::class.java)
        configuration.apply {
            group.convention(GroupDefault)
            id.convention(target.name)
            version.convention("1.0.0")
        }

    }
}

private const val MavenPublish = "maven-publish"
private const val GroupDefault = "com.splanes.komposier"
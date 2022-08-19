// FIXME - Pending to finish

plugins {
    id("com.android.library")
    `maven-publish`
    checkstyle
}

group = project.android.namespace.orEmpty()
version = project.extra["${project.name}.version"]?.toString().orEmpty()

java {
    withJavadocJar()
    withSourcesJar()
}

afterEvaluate {
    publishing {
        publications {
            listOf("release", "debug").forEach { pubTaskName ->
                create<MavenPublication>(pubTaskName) {
                    artifactId = project.extra["${project.name}.artifact"]?.toString() ?: project.name
                    from(components.getByName(pubTaskName))
                    versionMapping {
                        usage("java-api") {
                            fromResolutionOf("runtimeClasspath")
                        }
                        usage("java-runtime") {
                            fromResolutionResult()
                        }
                    }
                    pom {
                        name.set("kompoiser.")
                        description.set("A concise description of my library")
                        url.set("http://www.example.com/library")
                        properties.set(mapOf(
                            "myProp" to "value",
                            "prop.with.dots" to "anotherValue"
                        ))
                        licenses {
                            license {
                                name.set("The Apache License, Version 2.0")
                                url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                            }
                        }
                        developers {
                            developer {
                                id.set("johnd")
                                name.set("John Doe")
                                email.set("john.doe@example.com")
                            }
                        }
                        scm {
                            connection.set("scm:git:git://example.com/my-library.git")
                            developerConnection.set("scm:git:ssh://example.com/my-library.git")
                            url.set("http://example.com/my-library/")
                        }
                    }
                }
            }
        }
        repositories {
            maven {
                // change URLs to point to your repos, e.g. http://my.org/repo
                val releasesRepoUrl = uri(layout.buildDirectory.dir("repos/releases"))
                val snapshotsRepoUrl = uri(layout.buildDirectory.dir("repos/snapshots"))
                url = if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl
            }
        }
    }
}


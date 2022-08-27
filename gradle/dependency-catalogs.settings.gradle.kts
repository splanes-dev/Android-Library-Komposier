dependencyResolutionManagement {
	versionCatalogs {
		create("baseLibs") {
			from(files("base.libs.versions.toml"))
		}
		create("androidLibs") {
			from(files("android.libs.versions.toml"))
		}
		create("testLibs") {
			from(files("test.libs.versions.toml"))
		}
	}
	repositories {
		google()
		mavenCentral()
		maven {
			url = uri("https://jitpack.io")
			content { includeGroupByRegex("com\\.github.*") }
		}
		maven {
			url = uri("https://oss.sonatype.org/content/repositories/snapshots")
			content { includeVersionByRegex(".*", ".*", ".*-SNAPSHOT") }
		}
	}
}

import org.gradle.api.tasks.testing.Test

fun Test.isExample() = name.contains("example", ignoreCase = true)

import groovy.lang.MissingPropertyException
import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.extra
import org.gradle.plugin.use.PluginDependency

enum class ProjectType {
    Application,
    Library
}

inline val Project.isApp get() = name.contains("app", ignoreCase = true)

inline val Project.type get() = if (isApp) ProjectType.Application else ProjectType.Library

@kotlin.jvm.Throws
fun Project.propertyStringOf(name: String): String = extra[name]?.toString()
    ?: throw MissingPropertyException("Missing property `$name` on gradle.properties.")

fun Project.apply(provider: Provider<PluginDependency>) = apply(plugin = provider.get().pluginId)

fun Project.onEachModule(config: Project.() -> Unit) {
    subprojects
        .filter { project -> project.childProjects.isEmpty() }
        .forEach(config)
}

fun Project.androidConfig(config: com.android.build.gradle.BaseExtension.() -> Unit) {
    configure<com.android.build.gradle.BaseExtension> { config() }
}

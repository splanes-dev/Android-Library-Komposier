import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.apply
import org.gradle.kotlin.dsl.configure
import org.gradle.plugin.use.PluginDependency

enum class ProjectType {
    Application,
    Library
}

inline val Project.isApp get() = name.contains("app", ignoreCase = true)

inline val Project.type get() = if (isApp) ProjectType.Application else ProjectType.Library
fun Project.apply(provider: Provider<PluginDependency>) = apply(plugin = provider.get().pluginId)

fun Project.onEachModule(config: Project.() -> Unit) {
    subprojects
        .filter { project -> project.childProjects.isEmpty() }
        .forEach(config)
}

fun Project.androidConfig(config: com.android.build.gradle.BaseExtension.() -> Unit) {
    configure<com.android.build.gradle.BaseExtension> { config() }
}

fun <T> DependencyHandlerScope.implementation(provider: Provider<T>) {
    "implementation"(provider)
}

fun <T> DependencyHandlerScope.kapt(provider: Provider<T>) {
    "kapt"(provider)
}

fun <T> DependencyHandlerScope.testImplementation(provider: Provider<T>) {
    "testImplementation"(provider)
}

fun <T> DependencyHandlerScope.androidTestImplementation(provider: Provider<T>) {
    "androidTestImplementation"(provider)
}
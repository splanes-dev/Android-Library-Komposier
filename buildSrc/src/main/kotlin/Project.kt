import org.gradle.api.Project
import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.apply
import org.gradle.plugin.use.PluginDependency

inline val Project.isApp get() = name.contains("app", ignoreCase = true)
fun Project.apply(provider: Provider<PluginDependency>) = apply(plugin = provider.get().pluginId)

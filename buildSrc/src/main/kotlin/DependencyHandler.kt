import org.gradle.api.provider.Provider
import org.gradle.kotlin.dsl.DependencyHandlerScope


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
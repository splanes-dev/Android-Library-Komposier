package com.splanes.komposier.uitheme.theme.providers

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.komposier.commons.errors.ErrorLogger
import com.splanes.komposier.commons.tag.tag
import com.splanes.komposier.uitheme.theme.models.Theme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.colors.scheme
import com.splanes.komposier.uitheme.theme.models.colors.toMaterialColorScheme
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.shapes.toMaterialShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles
import com.splanes.komposier.uitheme.theme.models.typographies.toMaterialTypo
import kotlin.reflect.KClass

interface ThemeProvider<T : Theme> {

    val localTheme: ProvidableCompositionLocal<T>

    val localColors get() = staticCompositionLocalOf(ThemeColors::class)
    val localTextStyles get() = staticCompositionLocalOf(ThemeTextStyles::class)
    val localShapes get() = staticCompositionLocalOf(ThemeShapes::class)
    val localUiMode get() = staticCompositionLocalOf(Theme.Mode::class)

    @Composable
    fun currentLocalTheme(): T = localTheme.current

    @Composable
    fun ThemeComposition(theme: Theme = currentLocalTheme(), content: @Composable () -> Unit) {
        CompositionLocalProvider(
            localUiMode provides theme.mode,
            localColors provides theme.colors,
            localTextStyles provides theme.textStyles,
            localShapes provides theme.shapes
        ) {
            MaterialTheme(
                colorScheme = localColors.current.scheme().toMaterialColorScheme(),
                shapes = localShapes.current.toMaterialShapes(),
                typography = localTextStyles.current.toMaterialTypo(),
                content = content
            )
        }
    }

    fun <T : Any> staticCompositionLocalOf(clazz: KClass<T>) =
        staticCompositionLocalOf<T> {
            NotProvidedException(clazz.tag).`throw`()
        }

    class NotProvidedException( value: String) :
        RuntimeException(),
        ErrorLogger by ErrorLogger.Delegate() {
        override val message: String =
            "Impossible to create static composition local of ${value}, is not provided."
    }

    companion object
}
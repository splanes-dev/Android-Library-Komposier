package com.splanes.komposier.contracts.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.komposier.contracts.theme.colors.ThemeColors
import com.splanes.komposier.contracts.theme.colors.toMaterialColorScheme
import com.splanes.komposier.contracts.theme.shapes.ThemeShapes
import com.splanes.komposier.contracts.theme.shapes.toMaterialShapes
import com.splanes.komposier.contracts.theme.typographies.ThemeTextStyles
import com.splanes.komposier.contracts.theme.typographies.toMaterialTypo

interface ThemeContract {
    fun provideTheme(theme: Theme)
}

object AppTheme : ThemeContract {

    private val current: Theme
        @Composable
        @ReadOnlyComposable
        get() = LocalTheme.current

    internal lateinit var LocalTheme: ProvidableCompositionLocal<Theme>

    internal val LocalThemeMode = staticCompositionLocalOf { Theme.Mode.System }
    internal val LocalColors = staticCompositionLocalOf<ThemeColors>()
    internal val LocalTextStyles = staticCompositionLocalOf<ThemeTextStyles>()
    internal val LocalShapes = staticCompositionLocalOf<ThemeShapes>()

    override fun provideTheme(theme: Theme) {
        LocalTheme = staticCompositionLocalOf { theme }
    }

    @Composable
    private fun ThemeProvider(theme: Theme, content: @Composable () -> Unit) {
        CompositionLocalProvider(
            LocalThemeMode provides theme.mode,
            LocalColors provides theme.colors,
            LocalTextStyles provides theme.textStyles,
            LocalShapes provides theme.shapes
        ) {
            MaterialTheme(
                colorScheme = LocalColors.current.scheme().toMaterialColorScheme(),
                shapes = LocalShapes.current.toMaterialShapes(),
                typography = LocalTextStyles.current.toMaterialTypo(),
                content = content
            )
        }
    }

    @Composable
    internal fun Theme(
        theme: Theme = current,
        content: @Composable () -> Unit
    ) {
        ThemeProvider(theme, content)
    }

    @Composable
    fun ThemeColors.scheme() = when (LocalThemeMode.current) {
        Theme.Mode.Light -> light
        Theme.Mode.Dark -> dark
        Theme.Mode.System -> if (isSystemInDarkTheme()) dark else light
    }
}

@Composable
fun Theme(content: @Composable () -> Unit) {
    AppTheme.Theme(content = content)
}

private inline fun <reified T> staticCompositionLocalOf() = staticCompositionLocalOf<T> {
    error("${T::class.simpleName} not provided")
}
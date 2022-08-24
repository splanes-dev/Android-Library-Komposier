package com.splanes.komposier.ui.theme.providers

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import com.splanes.komposier.ui.theme.models.SystemUiMode
import com.splanes.komposier.ui.theme.models.Theme
import com.splanes.komposier.ui.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.ui.theme.models.colors.scheme
import com.splanes.komposier.ui.theme.models.colors.toMaterialColorScheme
import com.splanes.komposier.ui.theme.models.shapes.ThemeShapes
import com.splanes.komposier.ui.theme.models.shapes.toMaterialShapes
import com.splanes.komposier.ui.theme.models.typographies.ThemeTextStyles
import com.splanes.komposier.ui.theme.models.typographies.toMaterialTypo

interface ThemeProvider<T : Theme> {

    val localTheme: T
    val localColorScheme: ProvidableCompositionLocal<ThemeColorScheme>
    val localTextStyles: ProvidableCompositionLocal<ThemeTextStyles>
    val localShapes: ProvidableCompositionLocal<ThemeShapes>

    @Composable
    fun ThemeComposition(
        theme: Theme = localTheme,
        themeUiMode: Theme.UiMode = Theme.SystemUiMode,
        content: @Composable () -> Unit
    ) {
        val colorScheme = theme.colors.scheme(themeUiMode)

        CompositionLocalProvider(
            localColorScheme provides colorScheme,
            localTextStyles provides theme.textStyles,
            localShapes provides theme.shapes
        ) {
            MaterialTheme(
                colorScheme = localColorScheme.current.toMaterialColorScheme(),
                shapes = localShapes.current.toMaterialShapes(),
                typography = localTextStyles.current.toMaterialTypo(),
                content = content
            )
        }
    }

    companion object
}

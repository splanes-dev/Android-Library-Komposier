package com.splanes.komposier.uitheme.theme.providers

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.komposier.commons.errors.BaseException
import com.splanes.komposier.commons.tag.tag
import com.splanes.komposier.uitheme.theme.models.SystemUiMode
import com.splanes.komposier.uitheme.theme.models.Theme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.colors.scheme
import com.splanes.komposier.uitheme.theme.models.colors.toMaterialColorScheme
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.shapes.toMaterialShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles
import com.splanes.komposier.uitheme.theme.models.typographies.toMaterialTypo
import kotlin.reflect.KClass

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
package com.splanes.komposier.uitheme.theme.providers

import androidx.compose.runtime.ProvidableCompositionLocal
import com.splanes.komposier.uitheme.theme.models.Theme
import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.komposier.uitheme.theme.defaults.DefaultColors
import com.splanes.komposier.uitheme.theme.defaults.DefaultShapes
import com.splanes.komposier.uitheme.theme.defaults.DefaultTextStyles
import com.splanes.komposier.uitheme.theme.defaults.ThemeDefaults
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles

fun <T : Theme> ThemeProvider.Companion.of(theme: T): ThemeProvider<T> =
    object : ThemeProvider<T> {
        override val localTheme: ProvidableCompositionLocal<T> = staticCompositionLocalOf { theme }
    }

fun ThemeProvider.Companion.fromDefaults(
    colors: DefaultColors,
    textStyles: DefaultTextStyles,
    shapes: DefaultShapes
): ThemeProvider<Theme> = of(
    object : Theme {
        override val colors: ThemeColors = ThemeDefaults.themeColorsOf(colors)
        override val textStyles: ThemeTextStyles = ThemeDefaults.textStylesOf(textStyles)
        override val shapes: ThemeShapes =  ThemeDefaults.shapesOf(shapes)
        override val paddings: ThemePaddings = ThemeDefaults.paddings()
    }
)
package com.splanes.komposier.uitheme.theme.providers

import androidx.compose.runtime.staticCompositionLocalOf
import com.splanes.komposier.commons.errors.BaseException
import com.splanes.komposier.commons.tag.tag
import com.splanes.komposier.uitheme.theme.defaults.DefaultColors
import com.splanes.komposier.uitheme.theme.defaults.DefaultShapes
import com.splanes.komposier.uitheme.theme.defaults.DefaultTextStyles
import com.splanes.komposier.uitheme.theme.defaults.ThemeDefaults
import com.splanes.komposier.uitheme.theme.models.Theme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles
import kotlin.reflect.KClass

fun Theme.Companion.build(
    colors: ThemeColors,
    textStyles: ThemeTextStyles,
    shapes: ThemeShapes,
    paddings: ThemePaddings,
): Theme = object : Theme {
    override val colors: ThemeColors = colors
    override val textStyles: ThemeTextStyles = textStyles
    override val shapes: ThemeShapes = shapes
    override val paddings: ThemePaddings = paddings
}

fun <T : Theme> ThemeProvider.Companion.provides(theme: T): ThemeProvider<T> =
    object : ThemeProvider<T> {
        override val localTheme: T = theme
        override val localColorScheme = staticCompositionLocalOf(ThemeColorScheme::class)
        override val localTextStyles = staticCompositionLocalOf(ThemeTextStyles::class)
        override val localShapes = staticCompositionLocalOf(ThemeShapes::class)
    }

fun ThemeProvider.Companion.fromDefaults(
    colors: DefaultColors,
    textStyles: DefaultTextStyles,
    shapes: DefaultShapes,
): ThemeProvider<Theme> =
    ThemeProvider.provides(
        Theme.build(
            ThemeDefaults.themeColorsOf(colors),
            ThemeDefaults.textStylesOf(textStyles),
            ThemeDefaults.shapesOf(shapes),
            ThemeDefaults.paddings(),
        )
    )

internal fun <T : Any> staticCompositionLocalOf(clazz: KClass<T>) =
    staticCompositionLocalOf<T> { NotProvidedException(clazz.tag).`throw`() }

internal class NotProvidedException(value: String) : BaseException() {
    override val message: String =
        "Impossible to create static composition local of ${value}, is not provided."
}
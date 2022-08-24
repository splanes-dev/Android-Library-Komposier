package com.splanes.komposier.ui.theme.defaults

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.ui.theme.defaults.colors.AmberThemeColors
import com.splanes.komposier.ui.theme.defaults.colors.ButterflyBushThemeColors
import com.splanes.komposier.ui.theme.defaults.colors.MediumCarmineThemeColors
import com.splanes.komposier.ui.theme.defaults.colors.OrientThemeColors
import com.splanes.komposier.ui.theme.defaults.shapes.RectangleShapes
import com.splanes.komposier.ui.theme.defaults.shapes.RoundedShapes
import com.splanes.komposier.ui.theme.defaults.textstyles.ApercuQuickSansTextStyles
import com.splanes.komposier.ui.theme.defaults.textstyles.EncodeRobotoTextStyles
import com.splanes.komposier.ui.theme.defaults.textstyles.LatoApercuTextStyles
import com.splanes.komposier.ui.theme.models.colors.ThemeColors
import com.splanes.komposier.ui.theme.models.paddings.ThemePaddings
import com.splanes.komposier.ui.theme.models.shapes.ThemeShapes
import com.splanes.komposier.ui.theme.models.typographies.ThemeTextStyles

object ThemeDefaults {

    fun themeColorsOf(defaultColors: DefaultColors): ThemeColors =
        when (defaultColors) {
            DefaultColors.MediumCarmine -> MediumCarmineThemeColors
            DefaultColors.ButterflyBush -> ButterflyBushThemeColors
            DefaultColors.Orient -> OrientThemeColors
            DefaultColors.Amber -> AmberThemeColors
        }.colors()

    fun textStylesOf(defaultTextStyles: DefaultTextStyles): ThemeTextStyles =
        when (defaultTextStyles) {
            DefaultTextStyles.EncodeRoboto -> EncodeRobotoTextStyles
            DefaultTextStyles.LatoApercu -> LatoApercuTextStyles
            DefaultTextStyles.ApercuQuicksans -> ApercuQuickSansTextStyles
        }

    fun shapesOf(defaultShapes: DefaultShapes): ThemeShapes =
        when (defaultShapes) {
            DefaultShapes.Rectangle -> RectangleShapes
            DefaultShapes.Rounded -> RoundedShapes
        }

    fun paddings(): ThemePaddings = object : ThemePaddings {
        override val extraSmall: Dp = 2.dp
        override val small: Dp = 4.dp
        override val mediumSmall: Dp = 8.dp
        override val medium: Dp = 12.dp
        override val mediumLarge: Dp = 16.dp
        override val large: Dp = 24.dp
        override val extraLarge: Dp = 32.dp
    }
}

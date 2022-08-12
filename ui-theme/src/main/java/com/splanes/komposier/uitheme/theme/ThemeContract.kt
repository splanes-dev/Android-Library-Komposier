package com.splanes.komposier.uitheme.theme

import com.splanes.komposier.uitheme.theme.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.typographies.ThemeTextStyles

interface Theme {
    val colors: ThemeColors
    val textStyles: ThemeTextStyles
    val paddings: ThemePaddings
    val shapes: ThemeShapes
    val mode: Mode get() = Mode.System

    enum class Mode {
        Light,
        Dark,
        System
    }
}

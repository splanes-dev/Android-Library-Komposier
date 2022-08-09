package com.splanes.komposier.contracts.theme

import com.splanes.komposier.contracts.theme.colors.ThemeColors
import com.splanes.komposier.contracts.theme.paddings.ThemePaddings
import com.splanes.komposier.contracts.theme.shapes.ThemeShapes
import com.splanes.komposier.contracts.theme.typographies.ThemeTextStyles

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

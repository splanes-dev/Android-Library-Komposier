package com.splanes.komposier.uitheme.theme.models

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.splanes.komposier.uitheme.theme.AppTheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles

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

package com.splanes.komposier.uitheme.theme.defaults.colors

import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors

interface DefaultThemeColors {
    val light: ThemeColorScheme
    val dark: ThemeColorScheme
    fun colors(): ThemeColors = ThemeColors(light, dark)
}
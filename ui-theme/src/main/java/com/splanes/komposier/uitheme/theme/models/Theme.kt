package com.splanes.komposier.uitheme.theme.models

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import com.splanes.komposier.uitheme.theme.models.colors.systemScheme
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles

interface Theme {
    val colors: ThemeColors
    val textStyles: ThemeTextStyles
    val paddings: ThemePaddings
    val shapes: ThemeShapes
    enum class UiMode {
        Light,
        Dark,
        System;

        @Composable
        fun isDarkMode() = this == Dark || isSystemInDarkTheme()

        @Composable
        fun colorScheme(colors: ThemeColors) = when (this) {
            Light -> colors.light
            Dark -> colors.dark
            System -> colors.systemScheme()
        }
    }
    companion object
}

val Theme.Companion.LightUiMode get() = Theme.UiMode.Light
val Theme.Companion.DarkUiMode get() = Theme.UiMode.Dark
val Theme.Companion.SystemUiMode get() = Theme.UiMode.System

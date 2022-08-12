package com.splanes.komposier.uitheme.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.splanes.komposier.uitheme.theme.AppTheme.scheme
import com.splanes.komposier.uitheme.theme.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.typographies.ThemeTextStyles

val Colors: ThemeColorScheme
    @Composable
    get() = AppTheme.LocalColors.current.scheme()

val ThemeMode: Theme.Mode
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.LocalThemeMode.current

val TextStyles: ThemeTextStyles
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.LocalTextStyles.current

val Shapes: ThemeShapes
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.LocalShapes.current

val Paddings: ThemePaddings
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.LocalTheme.current.paddings



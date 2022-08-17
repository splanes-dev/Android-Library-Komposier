package com.splanes.komposier.uitheme.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles

val Colors: ThemeColorScheme
    @Composable
    get() = AppTheme.provider.localColorScheme.current

val TextStyles: ThemeTextStyles
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.provider.localTextStyles.current

val Shapes: ThemeShapes
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.provider.localShapes.current

val Paddings: ThemePaddings
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.provider.localTheme.paddings



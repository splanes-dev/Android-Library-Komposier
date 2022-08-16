package com.splanes.komposier.uitheme.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import com.splanes.komposier.uitheme.theme.models.Theme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.scheme
import com.splanes.komposier.uitheme.theme.models.paddings.ThemePaddings
import com.splanes.komposier.uitheme.theme.models.shapes.ThemeShapes
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles

val Colors: ThemeColorScheme
    @Composable
    get() = AppTheme.safeProvider().localColors.current.scheme()

val ThemeMode: Theme.Mode
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.safeProvider().localUiMode.current

val TextStyles: ThemeTextStyles
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.safeProvider().localTextStyles.current

val Shapes: ThemeShapes
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.safeProvider().localShapes.current

val Paddings: ThemePaddings
    @Composable
    @ReadOnlyComposable
    get() = AppTheme.safeProvider().localTheme.current.paddings



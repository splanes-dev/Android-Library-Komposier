package com.splanes.komposier.uitheme.theme.models.colors

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.uitheme.theme.AppTheme
import com.splanes.komposier.uitheme.theme.models.SystemUiMode
import com.splanes.komposier.uitheme.theme.models.Theme

interface ThemeColorScheme {
    val primary: Color
    val onPrimary: Color
    val primaryContainer: Color
    val onPrimaryContainer: Color
    val inversePrimary: Color
    val secondary: Color
    val onSecondary: Color
    val secondaryContainer: Color
    val onSecondaryContainer: Color
    val tertiary: Color
    val onTertiary: Color
    val tertiaryContainer: Color
    val onTertiaryContainer: Color
    val background: Color
    val onBackground: Color
    val surface: Color
    val onSurface: Color
    val surfaceVariant: Color
    val onSurfaceVariant: Color
    val surfaceTint: Color
    val inverseSurface: Color
    val inverseOnSurface: Color
    val error: Color
    val onError: Color
    val errorContainer: Color
    val onErrorContainer: Color
    val outline: Color
    val outlineVariant: Color
    val scrim: Color
    val success: Color
    val successContainer: Color
    val onSuccessContainer: Color
    val warning: Color
    val warningContainer: Color
    val onWarningContainer: Color
    val info: Color
    val infoContainer: Color
    val onInfoContainer: Color

    companion object
}

fun ThemeColorScheme.Companion.of(
    primary: Color,
    onPrimary: Color,
    primaryContainer: Color,
    onPrimaryContainer: Color,
    inversePrimary: Color,
    secondary: Color,
    onSecondary: Color,
    secondaryContainer: Color,
    onSecondaryContainer: Color,
    tertiary: Color,
    onTertiary: Color,
    tertiaryContainer: Color,
    onTertiaryContainer: Color,
    background: Color,
    onBackground: Color,
    surface: Color,
    onSurface: Color,
    surfaceVariant: Color,
    onSurfaceVariant: Color,
    surfaceTint: Color,
    inverseSurface: Color,
    inverseOnSurface: Color,
    error: Color,
    onError: Color,
    errorContainer: Color,
    onErrorContainer: Color,
    outline: Color,
    outlineVariant: Color,
    scrim: Color,
    success: Color,
    successContainer: Color,
    onSuccessContainer: Color,
    warning: Color,
    warningContainer: Color,
    onWarningContainer: Color,
    info: Color,
    infoContainer: Color,
    onInfoContainer: Color,
): ThemeColorScheme =
    object : ThemeColorScheme {
        override val primary: Color = primary
        override val onPrimary: Color = onPrimary
        override val primaryContainer: Color = primaryContainer
        override val onPrimaryContainer: Color = onPrimaryContainer
        override val inversePrimary: Color = inversePrimary
        override val secondary: Color = secondary
        override val onSecondary: Color = onSecondary
        override val secondaryContainer: Color = secondaryContainer
        override val onSecondaryContainer: Color = onSecondaryContainer
        override val tertiary: Color = tertiary
        override val onTertiary: Color = onTertiary
        override val tertiaryContainer: Color = tertiaryContainer
        override val onTertiaryContainer: Color = onTertiaryContainer
        override val background: Color = background
        override val onBackground: Color = onBackground
        override val surface: Color = surface
        override val onSurface: Color = onSurface
        override val surfaceVariant: Color = surfaceVariant
        override val onSurfaceVariant: Color = onSurfaceVariant
        override val surfaceTint: Color = surfaceTint
        override val inverseSurface: Color = inverseSurface
        override val inverseOnSurface: Color = inverseOnSurface
        override val error: Color = error
        override val onError: Color = onError
        override val errorContainer: Color = errorContainer
        override val onErrorContainer: Color = onErrorContainer
        override val outline: Color = outline
        override val outlineVariant: Color = outlineVariant
        override val scrim: Color = scrim
        override val success: Color = success
        override val successContainer: Color = successContainer
        override val onSuccessContainer: Color = onSuccessContainer
        override val warning: Color = warning
        override val warningContainer: Color = warningContainer
        override val onWarningContainer: Color = onWarningContainer
        override val info: Color = info
        override val infoContainer: Color = infoContainer
        override val onInfoContainer: Color = onInfoContainer
    }

fun ThemeColorScheme.toMaterialColorScheme(): ColorScheme = ColorScheme(
    primary = primary,
    onPrimary = onPrimary,
    primaryContainer = primaryContainer,
    onPrimaryContainer = onPrimaryContainer,
    inversePrimary = inversePrimary,
    secondary = secondary,
    onSecondary = onSecondary,
    secondaryContainer = secondaryContainer,
    onSecondaryContainer = onSecondaryContainer,
    tertiary = tertiary,
    onTertiary = onTertiary,
    tertiaryContainer = tertiaryContainer,
    onTertiaryContainer = onTertiaryContainer,
    background = background,
    onBackground = onBackground,
    surface = surface,
    onSurface = onSurface,
    surfaceVariant = surfaceVariant,
    onSurfaceVariant = onSurfaceVariant,
    surfaceTint = surfaceTint,
    inverseSurface = inverseSurface,
    inverseOnSurface = inverseOnSurface,
    error = error,
    onError = onError,
    errorContainer = errorContainer,
    onErrorContainer = onErrorContainer,
    outline = outline,
    outlineVariant = outlineVariant,
    scrim = scrim,
)

@Composable
fun ThemeColors.systemScheme() = if (isSystemInDarkTheme()) dark else light

@Composable
fun ThemeColors.scheme(themeUiMode: Theme.UiMode = Theme.SystemUiMode): ThemeColorScheme =
    when (themeUiMode) {
        Theme.UiMode.Light -> light
        Theme.UiMode.Dark -> dark
        Theme.UiMode.System -> systemScheme()
    }
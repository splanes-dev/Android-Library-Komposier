package com.splanes.komposier.ui.theme.tokens

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.ui.theme.Colors

enum class ColorSchemeTokens {
    Background,
    Error,
    ErrorContainer,
    InverseOnSurface,
    InversePrimary,
    InverseSurface,
    OnBackground,
    OnError,
    OnErrorContainer,
    OnPrimary,
    OnPrimaryContainer,
    OnSecondary,
    OnSecondaryContainer,
    OnSurface,
    OnSurfaceVariant,
    OnTertiary,
    OnTertiaryContainer,
    Outline,
    OutlineVariant,
    Primary,
    PrimaryContainer,
    Scrim,
    Secondary,
    SecondaryContainer,
    Surface,
    SurfaceTint,
    SurfaceVariant,
    Tertiary,
    TertiaryContainer,
    Success,
    SuccessContainer,
    OnSuccessContainer,
    Warning,
    WarningContainer,
    OnWarningContainer,
    Info,
    InfoContainer,
    OnInfoContainer,
}

@Composable
fun ColorSchemeTokens.toColor(): Color =
    when (this) {
        ColorSchemeTokens.Background -> Colors.background
        ColorSchemeTokens.Error -> Colors.error
        ColorSchemeTokens.ErrorContainer -> Colors.errorContainer
        ColorSchemeTokens.InverseOnSurface -> Colors.inverseOnSurface
        ColorSchemeTokens.InversePrimary -> Colors.inversePrimary
        ColorSchemeTokens.InverseSurface -> Colors.inverseSurface
        ColorSchemeTokens.OnBackground -> Colors.onBackground
        ColorSchemeTokens.OnError -> Colors.onError
        ColorSchemeTokens.OnErrorContainer -> Colors.onErrorContainer
        ColorSchemeTokens.OnPrimary -> Colors.onPrimary
        ColorSchemeTokens.OnPrimaryContainer -> Colors.onPrimaryContainer
        ColorSchemeTokens.OnSecondary -> Colors.onSecondary
        ColorSchemeTokens.OnSecondaryContainer -> Colors.onSecondaryContainer
        ColorSchemeTokens.OnSurface -> Colors.onSurface
        ColorSchemeTokens.OnSurfaceVariant -> Colors.onSurfaceVariant
        ColorSchemeTokens.OnTertiary -> Colors.onTertiary
        ColorSchemeTokens.OnTertiaryContainer -> Colors.onTertiaryContainer
        ColorSchemeTokens.Outline -> Colors.outline
        ColorSchemeTokens.OutlineVariant -> Colors.outlineVariant
        ColorSchemeTokens.Primary -> Colors.primary
        ColorSchemeTokens.PrimaryContainer -> Colors.primaryContainer
        ColorSchemeTokens.Scrim -> Colors.scrim
        ColorSchemeTokens.Secondary -> Colors.secondary
        ColorSchemeTokens.SecondaryContainer -> Colors.secondaryContainer
        ColorSchemeTokens.Surface -> Colors.surface
        ColorSchemeTokens.SurfaceTint -> Colors.surfaceTint
        ColorSchemeTokens.SurfaceVariant -> Colors.surfaceVariant
        ColorSchemeTokens.Tertiary -> Colors.tertiary
        ColorSchemeTokens.TertiaryContainer -> Colors.tertiaryContainer
        ColorSchemeTokens.Success -> Colors.success
        ColorSchemeTokens.SuccessContainer -> Colors.successContainer
        ColorSchemeTokens.OnSuccessContainer -> Colors.onSuccessContainer
        ColorSchemeTokens.Warning -> Colors.warning
        ColorSchemeTokens.WarningContainer -> Colors.warningContainer
        ColorSchemeTokens.OnWarningContainer -> Colors.onWarningContainer
        ColorSchemeTokens.Info -> Colors.info
        ColorSchemeTokens.InfoContainer -> Colors.infoContainer
        ColorSchemeTokens.OnInfoContainer -> Colors.onInfoContainer
    }

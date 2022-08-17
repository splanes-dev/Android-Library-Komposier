package com.splanes.komposier.component.catalog.snackbar.tokens

import androidx.compose.ui.unit.dp
import com.splanes.komposier.uitheme.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.uitheme.theme.tokens.ElevationTokens
import com.splanes.komposier.uitheme.theme.tokens.ShapeTokens
import com.splanes.komposier.uitheme.theme.tokens.typography.TypographyTokens

internal object SnackbarTokens {

    val SingleLineContainerHeight by lazy { 48.dp }

    val ContainerHorizontalPaddings by lazy { 16.dp }
    val ContainerBottomPadding by lazy { 24.dp }
    val ContainerShape by lazy { ShapeTokens.CornerFull }

    val IconSize by lazy { 24.dp }
    val ContentTextStyle by lazy { TypographyTokens.BodyLarge }

    val ContentColorDefault by lazy { ColorSchemeTokens.InverseOnSurface }
    val ContainerColorDefault by lazy { ColorSchemeTokens.InverseSurface }
    val IconColorDefault by lazy { ColorSchemeTokens.Tertiary }

    val ContentColorSuccess by lazy { ColorSchemeTokens.OnSuccessContainer }
    val ContainerColorSuccess by lazy { ColorSchemeTokens.SuccessContainer }
    val IconColorSuccess by lazy { ColorSchemeTokens.Success }

    val ContentColorWarning by lazy { ColorSchemeTokens.OnWarningContainer }
    val ContainerColorWarning by lazy { ColorSchemeTokens.WarningContainer }
    val IconColorWarning by lazy { ColorSchemeTokens.Warning }

    val ContentColorInfo by lazy { ColorSchemeTokens.OnInfoContainer }
    val ContainerColorInfo by lazy { ColorSchemeTokens.InfoContainer }
    val IconColorInfo by lazy { ColorSchemeTokens.Info }
}
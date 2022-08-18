package com.splanes.komposier.component.catalog.snackbar.tokens

import androidx.compose.ui.unit.dp
import com.splanes.komposier.uitheme.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.uitheme.theme.tokens.ShapeTokens
import com.splanes.komposier.uitheme.theme.tokens.typography.TypographyTokens

internal object SnackbarTokens {

    val SingleLineContainerHeight by lazy { 48.dp }
    val TwoLinesContainerHeight by lazy { 68.dp }

    val DismissButtonDelay by lazy { 2000L }
    val DismissButtonSize by lazy { 24.dp }
    val DismissButtonHorizontalPadding by lazy { 0.75.dp }

    val ContainerHorizontalPaddings by lazy { 20.dp }
    val ContainerBottomPadding by lazy { 24.dp }
    val ContainerShape by lazy { ShapeTokens.CornerFull }
    val ContainerColorDefault by lazy { ColorSchemeTokens.InverseSurface }
    val ContainerColorSuccess by lazy { ColorSchemeTokens.SuccessContainer }
    val ContainerColorWarning by lazy { ColorSchemeTokens.WarningContainer }
    val ContainerColorInfo by lazy { ColorSchemeTokens.InfoContainer }


    val IconSize by lazy { 24.dp }
    val IconColorDefault by lazy { ColorSchemeTokens.Tertiary }
    val IconColorSuccess by lazy { ColorSchemeTokens.Success }
    val IconColorWarning by lazy { ColorSchemeTokens.Warning }
    val IconColorInfo by lazy { ColorSchemeTokens.Info }

    val ContentTextStyle by lazy { TypographyTokens.BodyLarge }
    val ContentColorDefault by lazy { ColorSchemeTokens.InverseOnSurface }
    val ContentColorSuccess by lazy { ColorSchemeTokens.OnSuccessContainer }
    val ContentColorWarning by lazy { ColorSchemeTokens.OnWarningContainer }
    val ContentColorInfo by lazy { ColorSchemeTokens.OnInfoContainer }

}
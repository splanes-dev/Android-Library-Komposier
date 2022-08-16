package com.splanes.komposier.component.catalog.snackbar.tokens

import androidx.compose.material3.tokens.ElevationTokens
import androidx.compose.material3.tokens.ShapeKeyTokens
import androidx.compose.material3.tokens.TypographyKeyTokens
import androidx.compose.ui.unit.dp
import com.splanes.komposier.uitheme.theme.tokens.ColorSchemeTokens

internal object SnackbarTokens {
    val ActionFocusLabelTextColor = ColorSchemeTokens.InversePrimary
    val ActionHoverLabelTextColor = ColorSchemeTokens.InversePrimary
    val ActionLabelTextColor = ColorSchemeTokens.InversePrimary
    val ActionLabelTextFont = TypographyTokens.LabelLarge
    val ActionPressedLabelTextColor = ColorSchemeTokens.InversePrimary
    val ContainerColor = ColorSchemeTokens.InverseSurface
    val ContainerElevation = ElevationTokens.Level3
    val ContainerShape = ShapeTokens.CornerExtraSmall
    val IconColor = ColorSchemeTokens.InverseOnSurface
    val FocusIconColor = ColorSchemeTokens.InverseOnSurface
    val HoverIconColor = ColorSchemeTokens.InverseOnSurface
    val PressedIconColor = ColorSchemeTokens.InverseOnSurface
    val IconSize = 24.0.dp
    val SupportingTextColor = ColorSchemeTokens.InverseOnSurface
    val SupportingTextFont = TypographyTokens.BodyMedium
    val SingleLineContainerHeight = 48.0.dp
    val TwoLinesContainerHeight = 68.0.dp
}
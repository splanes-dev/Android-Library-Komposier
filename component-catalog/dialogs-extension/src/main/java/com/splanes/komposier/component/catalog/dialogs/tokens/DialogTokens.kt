package com.splanes.komposier.component.catalog.dialogs.tokens

import androidx.compose.ui.unit.dp
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.ElevationTokens
import com.splanes.komposier.ui.theme.tokens.ShapeTokens
import com.splanes.komposier.ui.theme.tokens.typography.TypographyTokens

object DialogTokens {
    val ActionLabelTextFont by lazy { TypographyTokens.LabelLarge }
    val ContainerColor by lazy { ColorSchemeTokens.Surface }
    val ContainerElevation by lazy { ElevationTokens.Level3 }
    val ContainerShape by lazy { ShapeTokens.CornerExtraLarge }
    val SubheadColor by lazy { ColorSchemeTokens.OnSurface }
    val SubheadFont by lazy { TypographyTokens.HeadlineSmall }
    val SupportingTextColor by lazy { ColorSchemeTokens.OnSurfaceVariant }
    val SupportingTextFont by lazy { TypographyTokens.BodyMedium }
    val IconColor by lazy { ColorSchemeTokens.Secondary }
    val IconSize by lazy { 24.0.dp }
}

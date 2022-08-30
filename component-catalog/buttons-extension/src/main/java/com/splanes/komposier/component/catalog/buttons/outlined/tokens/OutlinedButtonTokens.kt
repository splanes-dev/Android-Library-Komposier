package com.splanes.komposier.component.catalog.buttons.outlined.tokens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ButtonTokens
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.ElevationTokens
import com.splanes.komposier.ui.theme.tokens.ShapeTokens
import com.splanes.komposier.ui.theme.tokens.toColor

internal object OutlinedButtonTokens : ButtonTokens() {

    @Composable
    override fun buttonContentColor(): Color = ColorSchemeTokens.Primary.toColor()

    @Composable
    override fun buttonContentDisabledColor(): Color = ColorSchemeTokens.OnSurface.toColor()

    @Composable
    override fun buttonContainerColor(): Color = Color.Transparent

    @Composable
    override fun buttonContainerDisabledColor(): Color = Color.Transparent

    @Composable
    override fun buttonIconColor(): Color = ColorSchemeTokens.Primary.toColor()

    @Composable
    override fun buttonIconDisabledColor(): Color = ColorSchemeTokens.OnSurface.toColor()

    @Composable
    override fun buttonBorderColor(): Color = ColorSchemeTokens.Primary.toColor()

    @Composable
    override fun buttonBorderDisabledColor(): Color = ColorSchemeTokens.OnSurface.toColor()

    override val ButtonShape: ShapeTokens by lazy { ShapeTokens.CornerMedium }

    override val ButtonDefaultElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonPressedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonFocusedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonHoveredElevation: Dp by lazy { ElevationTokens.Level1 }
    override val ButtonDisabledElevation: Dp by lazy { ElevationTokens.Level0 }

    val ButtonContentPadding: PaddingValues by lazy { PaddingValues(horizontal = 8.dp, vertical = 4.dp) }
}

package com.splanes.komposier.component.catalog.buttons.filled.tokens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ButtonTokens
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.ElevationTokens
import com.splanes.komposier.ui.theme.tokens.ShapeTokens
import com.splanes.komposier.ui.theme.tokens.color

internal object FilledButtonTokens : ButtonTokens() {

    @Composable
    override fun buttonContentColor(): Color = ColorSchemeTokens.OnPrimary.color()

    @Composable
    override fun buttonContentDisabledColor(): Color = ColorSchemeTokens.OnSurface.color()

    @Composable
    override fun buttonContainerColor(): Color = ColorSchemeTokens.Primary.color()

    @Composable
    override fun buttonContainerDisabledColor(): Color = ColorSchemeTokens.Surface.color()

    @Composable
    override fun buttonIconColor(): Color = ColorSchemeTokens.OnPrimary.color()

    @Composable
    override fun buttonIconDisabledColor(): Color = ColorSchemeTokens.OnSurface.color()

    @Composable
    override fun buttonBorderColor(): Color = Color.Unspecified

    @Composable
    override fun buttonBorderDisabledColor(): Color = Color.Unspecified

    override val ButtonDefaultElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonPressedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonFocusedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonHoveredElevation: Dp by lazy { ElevationTokens.Level1 }
    override val ButtonDisabledElevation: Dp by lazy { ElevationTokens.Level0 }

    override val ButtonShape: ShapeTokens by lazy { ShapeTokens.CornerSmall }

    val ButtonContentPadding: PaddingValues by lazy { PaddingValues(horizontal = 8.dp, vertical = 4.dp) }
}

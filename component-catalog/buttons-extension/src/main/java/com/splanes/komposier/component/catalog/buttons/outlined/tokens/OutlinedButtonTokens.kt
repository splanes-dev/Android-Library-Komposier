package com.splanes.komposier.component.catalog.buttons.outlined.tokens

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ButtonTokens
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.ElevationTokens
import com.splanes.komposier.ui.theme.tokens.ShapeTokens

internal object OutlinedButtonTokens : ButtonTokens() {

    override val ButtonContentColor: ColorSchemeTokens by lazy { ColorSchemeTokens.Primary }
    override val ButtonContentDisabledColor: ColorSchemeTokens by lazy { ColorSchemeTokens.OnSurface }
    override val ButtonContainerColor: ColorSchemeTokens by lazy { ColorSchemeTokens.Surface }
    override val ButtonContainerDisabledColor: ColorSchemeTokens by lazy { ColorSchemeTokens.Surface }
    override val ButtonIconColor: ColorSchemeTokens by lazy { ColorSchemeTokens.Primary }
    override val ButtonIconDisabledColor: ColorSchemeTokens by lazy { ColorSchemeTokens.OnSurface }
    override val ButtonBorderColor: ColorSchemeTokens by lazy { ColorSchemeTokens.Primary }
    override val ButtonBorderDisabledColor: ColorSchemeTokens by lazy { ColorSchemeTokens.OnSurface }

    override val ButtonShape: ShapeTokens by lazy { ShapeTokens.CornerMedium }

    override val ButtonDefaultElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonPressedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonFocusedElevation: Dp by lazy { ElevationTokens.Level0 }
    override val ButtonHoveredElevation: Dp by lazy { ElevationTokens.Level1 }
    override val ButtonDisabledElevation: Dp by lazy { ElevationTokens.Level0 }

    val ButtonContentPadding: PaddingValues by lazy { PaddingValues(horizontal = 8.dp, vertical = 4.dp) }
}

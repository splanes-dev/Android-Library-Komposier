package com.splanes.komposier.component.catalog.buttons

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.ShapeTokens
import com.splanes.komposier.ui.theme.tokens.typography.TypographyTokens

internal abstract class ButtonTokens {

    abstract val ButtonContentColor: ColorSchemeTokens
    abstract val ButtonContentDisabledColor: ColorSchemeTokens
    abstract val ButtonContainerColor: ColorSchemeTokens
    abstract val ButtonContainerDisabledColor: ColorSchemeTokens
    abstract val ButtonIconColor: ColorSchemeTokens
    abstract val ButtonIconDisabledColor: ColorSchemeTokens
    abstract val ButtonBorderColor: ColorSchemeTokens
    abstract val ButtonBorderDisabledColor: ColorSchemeTokens

    abstract val ButtonShape: ShapeTokens

    abstract val ButtonDefaultElevation: Dp
    abstract val ButtonPressedElevation: Dp
    abstract val ButtonFocusedElevation: Dp
    abstract val ButtonHoveredElevation: Dp
    abstract val ButtonDisabledElevation: Dp

    companion object {
        val ButtonHeight by lazy { 48.dp }
        val ButtonHeightSmall by lazy { 42.dp }
        val ButtonIconSize by lazy { 20.dp }
        val ButtonWrapWidthDivisor by lazy { 0 }
        val ButtonSmallWidthDivisor by lazy { 5.2 }
        val ButtonMediumWidthDivisor by lazy { 4 }
        val ButtonLargeWidthDivisor by lazy { 1.75 }
        val ButtonFillWidthDivisor by lazy { Dp.Infinity }
        val ButtonIconPadding by lazy { PaddingValues(horizontal = 8.dp) }
        val ButtonSmallPadding by lazy { PaddingValues(horizontal = 4.dp, vertical = 2.dp) }
        val ButtonMediumPadding by lazy { PaddingValues(horizontal = 8.dp, vertical = 4.dp) }
        val ButtonLargePadding by lazy { PaddingValues(horizontal = 16.dp, vertical = 6.dp) }
        val ButtonSmallTextStyle by lazy { TypographyTokens.TitleMedium }
        val ButtonMediumTextStyle by lazy { TypographyTokens.TitleMedium }
        val ButtonLargeTextStyle by lazy { TypographyTokens.TitleMedium }
    }
}
package com.splanes.komposier.ui.theme.tokens

import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import com.splanes.komposier.ui.theme.Shapes

enum class ShapeTokens {
    CornerExtraLarge,
    CornerExtraLargeTop,
    CornerExtraSmall,
    CornerExtraSmallTop,
    CornerFull,
    CornerLarge,
    CornerLargeEnd,
    CornerLargeTop,
    CornerMedium,
    CornerNone,
    CornerSmall,
}

@Composable
fun ShapeTokens.shape() =
    when (this) {
        ShapeTokens.CornerExtraLarge -> Shapes.extraLarge
        ShapeTokens.CornerExtraLargeTop -> Shapes.extraLarge.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapeTokens.CornerExtraSmall -> Shapes.extraSmall
        ShapeTokens.CornerExtraSmallTop -> Shapes.extraSmall.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapeTokens.CornerFull -> Shapes.medium
        ShapeTokens.CornerLarge -> Shapes.large
        ShapeTokens.CornerLargeEnd -> Shapes.large.copy(
            topStart = ZeroCornerSize,
            bottomStart = ZeroCornerSize
        )
        ShapeTokens.CornerLargeTop -> Shapes.large.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapeTokens.CornerMedium -> Shapes.medium
        ShapeTokens.CornerNone -> RectangleShape
        ShapeTokens.CornerSmall -> Shapes.small
    }
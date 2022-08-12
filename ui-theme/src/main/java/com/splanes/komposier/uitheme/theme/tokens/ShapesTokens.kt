package com.splanes.komposier.uitheme.theme.tokens

import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.RectangleShape
import com.splanes.komposier.uitheme.theme.Shapes

enum class ShapesTokens {
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
fun ShapesTokens.shape() =
    when (this) {
        ShapesTokens.CornerExtraLarge -> Shapes.extraLarge
        ShapesTokens.CornerExtraLargeTop -> Shapes.extraLarge.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapesTokens.CornerExtraSmall -> Shapes.extraSmall
        ShapesTokens.CornerExtraSmallTop -> Shapes.extraSmall.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapesTokens.CornerFull -> Shapes.medium
        ShapesTokens.CornerLarge -> Shapes.large
        ShapesTokens.CornerLargeEnd -> Shapes.large.copy(
            topStart = ZeroCornerSize,
            bottomStart = ZeroCornerSize
        )
        ShapesTokens.CornerLargeTop -> Shapes.large.copy(
            bottomStart = ZeroCornerSize,
            bottomEnd = ZeroCornerSize
        )
        ShapesTokens.CornerMedium -> Shapes.medium
        ShapesTokens.CornerNone -> RectangleShape
        ShapesTokens.CornerSmall -> Shapes.small
    }
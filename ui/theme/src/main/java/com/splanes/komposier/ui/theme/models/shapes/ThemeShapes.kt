package com.splanes.komposier.ui.theme.models.shapes

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.material3.Shapes

interface ThemeShapes {
    val extraSmall: CornerBasedShape
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
    val extraLarge: CornerBasedShape

    companion object
}

fun ThemeShapes.toMaterialShapes() = Shapes(
    extraSmall = extraSmall,
    small = small,
    medium = medium,
    large = large,
    extraLarge = extraLarge
)

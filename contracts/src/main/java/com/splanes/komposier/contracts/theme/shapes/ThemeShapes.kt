package com.splanes.komposier.contracts.theme.shapes

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

interface ThemeShapes {
    val extraSmall: CornerBasedShape
    val small: CornerBasedShape
    val medium: CornerBasedShape
    val large: CornerBasedShape
    val extraLarge: CornerBasedShape

    companion object
}

inline val ThemeShapes.Companion.Default get() = object : ThemeShapes {
    override val extraSmall: CornerBasedShape = RoundedCornerShape(2.dp)
    override val small: CornerBasedShape
        get() = TODO("Not yet implemented")
    override val medium: CornerBasedShape
        get() = TODO("Not yet implemented")
    override val large: CornerBasedShape
        get() = TODO("Not yet implemented")
    override val extraLarge: CornerBasedShape
        get() = TODO("Not yet implemented")

}

fun ThemeShapes.toMaterialShapes() = Shapes(
    extraSmall = extraSmall,
    small = small,
    medium = medium,
    large = large,
    extraLarge = extraLarge,
)
package com.splanes.komposier.ui.theme.defaults.shapes

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.shape.ZeroCornerSize
import com.splanes.komposier.ui.theme.models.shapes.ThemeShapes

internal object RectangleShapes : ThemeShapes {
    override val extraSmall: CornerBasedShape = RoundedCornerShape(corner = ZeroCornerSize)
    override val small: CornerBasedShape = RoundedCornerShape(corner = ZeroCornerSize)
    override val medium: CornerBasedShape = RoundedCornerShape(corner = ZeroCornerSize)
    override val large: CornerBasedShape = RoundedCornerShape(corner = ZeroCornerSize)
    override val extraLarge: CornerBasedShape = RoundedCornerShape(corner = ZeroCornerSize)
}

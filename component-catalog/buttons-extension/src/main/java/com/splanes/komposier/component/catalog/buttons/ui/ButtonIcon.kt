package com.splanes.komposier.component.catalog.buttons.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.Dp

interface ButtonIcon {
    val icon: ImageVector
    val size: Dp
    val horizontalPadding: PaddingValues
    val position: RelativePosition

    enum class RelativePosition {
        Leading,
        Trailing
    }

    companion object {

        val Leading: RelativePosition = RelativePosition.Leading
        val Trailing: RelativePosition = RelativePosition.Trailing

        fun buttonIconOf(
            icon: ImageVector,
            size: Dp,
            horizontalPadding: PaddingValues,
            position: RelativePosition
        ) = object : ButtonIcon {
            override val icon: ImageVector = icon
            override val size: Dp = size
            override val horizontalPadding: PaddingValues = horizontalPadding
            override val position: RelativePosition = position
        }
    }
}
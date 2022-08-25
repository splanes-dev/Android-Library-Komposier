package com.splanes.komposier.component.catalog.buttons.filled.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.component.catalog.buttons.ui.ButtonColors

interface FilledButtonColors : ButtonColors {

    @Composable
    override fun borderColor(enabled: Boolean): State<Color> = containerColor(enabled = enabled)

    companion object {

        @Composable
        fun colorsOf(
            contentColor: Color,
            contentDisabledColor: Color,
            containerColor: Color,
            containerDisabledColor: Color,
            iconColor: Color,
            iconDisabledColor: Color
        ) = object : FilledButtonColors {

            @Composable
            override fun iconColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) iconColor else iconDisabledColor)

            @Composable
            override fun containerColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) containerColor else containerDisabledColor)

            @Composable
            override fun contentColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) contentColor else contentDisabledColor)
        }
    }
}
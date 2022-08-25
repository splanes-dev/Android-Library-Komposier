package com.splanes.komposier.component.catalog.buttons.outlined.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.component.catalog.buttons.ui.ButtonColors

interface OutlinedButtonColors : ButtonColors {

    companion object {

        @Composable
        fun colorsOf(
            contentColor: Color,
            contentDisabledColor: Color,
            iconColor: Color,
            iconDisabledColor: Color
        ) = object : OutlinedButtonColors {

            @Composable
            override fun borderColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) contentColor else contentDisabledColor)

            @Composable
            override fun iconColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) iconColor else iconDisabledColor)

            @Composable
            override fun containerColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = Color.Transparent)

            @Composable
            override fun contentColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) contentColor else contentDisabledColor)
        }
    }
}
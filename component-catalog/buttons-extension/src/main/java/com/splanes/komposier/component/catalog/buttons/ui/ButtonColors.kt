package com.splanes.komposier.component.catalog.buttons.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.material3.ButtonColors as MaterialButtonColors

interface ButtonColors : MaterialButtonColors {

    @Composable
    fun iconColor(enabled: Boolean): State<Color>

    @Composable
    fun borderColor(enabled: Boolean): State<Color>

    companion object {

        @Composable
        fun buttonColorsOf(
            contentColor: Color,
            containerColor: Color,
            iconColor: Color = Color.Unspecified,
            borderColor: Color = Color.Unspecified,
            contentDisabledColor: Color,
            containerDisabledColor: Color,
            iconDisabledColor: Color,
            borderDisabledColor: Color,
        ) = object : ButtonColors {

            @Composable
            override fun borderColor(enabled: Boolean): State<Color> =
                rememberUpdatedState(newValue = if (enabled) borderColor else borderDisabledColor)

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
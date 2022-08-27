package com.splanes.komposier.component.catalog.forms.core.fields.visuals

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

interface FormFieldColors {
    @Composable
    fun containerColor(
        enabled: Boolean,
        focused: Boolean,
        error: Boolean
    ): State<Color>

    @Composable
    fun contentColor(
        enabled: Boolean,
        focused: Boolean,
        error: Boolean
    ): State<Color>
}

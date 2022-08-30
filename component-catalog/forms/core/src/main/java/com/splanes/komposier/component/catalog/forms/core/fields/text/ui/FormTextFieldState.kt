package com.splanes.komposier.component.catalog.forms.core.fields.text.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import com.splanes.komposier.commons.primitives.texts.Empty
import com.splanes.komposier.component.catalog.forms.core.fields.FormFieldState

@Composable
fun rememberFormTextFieldState(
    value: String = String.Empty,
    error: String? = null
): FormFieldState<String> = remember {
    if (error == null) {
        FormFieldState.Normal(value)
    } else {
        FormFieldState.Error(value, error)
    }
}

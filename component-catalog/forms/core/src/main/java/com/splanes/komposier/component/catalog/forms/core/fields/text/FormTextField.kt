package com.splanes.komposier.component.catalog.forms.core.fields.text

import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.splanes.komposier.component.catalog.forms.core.fields.FormFieldState
import com.splanes.komposier.component.catalog.forms.core.fields.text.ui.FormTextFieldData
import com.splanes.komposier.component.catalog.forms.core.fields.text.ui.FormTextFieldVisuals
import com.splanes.komposier.component.catalog.forms.core.fields.text.ui.rememberFormTextFieldState

@Composable
fun FormTextField(
    modifier: Modifier = Modifier,
    state: FormFieldState<String> = rememberFormTextFieldState(),
    data: FormTextFieldData = FormTextFieldData(
        visuals = FormTextFieldVisuals(
            colors = ,
            paddings = ,
            layout = ,
            placeholder = null,
            label = null,
            cleanable = false,
            inputType = ,

        ),
        onChangeValue = {}
    )
) {
    TextField(
        modifier = modifier,
        value = ,
        onValueChange =,
        enabled = ,
        readOnly = ,
        textStyle = ,
        label = {},
        placeholder = {},
        leadingIcon = {},
        trailingIcon = {},
        isError = ,
        visualTransformation = ,
        keyboardOptions = ,
        keyboardActions = ,
        singleLine = ,
        maxLines = ,
        shape = ,
        colors =
    )
}

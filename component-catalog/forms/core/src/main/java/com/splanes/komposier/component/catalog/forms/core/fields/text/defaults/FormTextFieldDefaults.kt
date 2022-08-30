package com.splanes.komposier.component.catalog.forms.core.fields.text.defaults

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import com.splanes.komposier.component.catalog.forms.core.fields.text.ui.FormTextFieldColors

object FormTextFieldDefaults {

    @Composable
    fun textFieldColors(): FormTextFieldColors = FormTextFieldColors(
        container = ,
        content =
    )

    fun textFieldPaddings(): PaddingValues = PaddingValues(
        horizontal = FormTextFieldTokens.TextFieldPaddings,
        vertical = FormTextFieldTokens.TextFieldPaddings
    )
}

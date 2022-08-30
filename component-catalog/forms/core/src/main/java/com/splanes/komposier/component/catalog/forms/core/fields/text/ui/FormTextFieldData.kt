package com.splanes.komposier.component.catalog.forms.core.fields.text.ui

import com.splanes.komposier.component.catalog.forms.core.fields.FormFieldData
import com.splanes.komposier.component.catalog.forms.core.fields.visuals.FormFieldVisuals

data class FormTextFieldData(
    override val visuals: FormFieldVisuals,
    override val onChangeValue: (String) -> Unit
) : FormFieldData<String>()

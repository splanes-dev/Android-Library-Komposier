package com.splanes.komposier.component.catalog.forms.core.fields.text.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.ui.graphics.vector.ImageVector
import com.splanes.komposier.component.catalog.forms.core.fields.text.defaults.FormTextFieldDefaults
import com.splanes.komposier.component.catalog.forms.core.fields.visuals.FormFieldColors
import com.splanes.komposier.component.catalog.forms.core.fields.visuals.FormFieldLayout
import com.splanes.komposier.component.catalog.forms.core.fields.visuals.FormFieldVisuals

data class FormTextFieldVisuals(
    override val colors: FormFieldColors = FormTextFieldDefaults.textFieldColors(),
    override val paddings: PaddingValues = FormTextFieldDefaults.textFieldPaddings(),
    override val layout: FormFieldLayout = FormTe,
    val label: String?,
    val placeholder: String?,
    val leadingIcon: ImageVector?,
    val trailingIcon: ImageVector?,
    val cleanable: Boolean,
    val inputType: FormTextFieldInputType,
    val
) : FormFieldVisuals

package com.splanes.komposier.component.catalog.forms.core.fields

import com.splanes.komposier.component.catalog.forms.core.fields.visuals.FormFieldVisuals

abstract class FormFieldData<T> {
    abstract val visuals: FormFieldVisuals
    abstract val onChangeValue: (T) -> Unit
    open val validators: List<FormFieldValidator<T>> = emptyList()
}

package com.splanes.komposier.component.catalog.forms.core

import com.splanes.komposier.component.catalog.forms.core.fields.FormFieldState
import kotlinx.coroutines.CoroutineScope

class FormState(
    val scope: CoroutineScope,
    val fields: List<FormFieldState<Any>>, // FIXME: Improve on future iterations
    val rules: List<Any> = emptyList() // FIXME: Improve on future iterations
) {

}

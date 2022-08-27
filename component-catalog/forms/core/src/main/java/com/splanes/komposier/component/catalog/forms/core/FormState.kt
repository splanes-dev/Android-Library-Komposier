package com.splanes.komposier.component.catalog.forms.core

import com.splanes.komposier.component.catalog.forms.core.fields.FormFieldState
import kotlinx.coroutines.CoroutineScope

class FormState(
    val scope: CoroutineScope,
    val fields: List<FormFieldState>,
    val rules: List<FormFieldBehavior>
) {

	suspend fun trySubmit() {

	}
}

package com.splanes.komposier.component.catalog.forms.core.fields

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember

sealed interface FormFieldState<T> {

    val input: T

    data class Normal<T>(override val input: T) : FormFieldState<T>

    data class Error<T>(override val input: T, val error: String) : FormFieldState<T>

    suspend fun update(validators: List<FormFieldValidator<T>>) =
        when (val result = validators.validateAll(input)) {
            FormFieldValidator.Valid -> Normal(input)
            is FormFieldValidator.Error -> Error(input, result.message)
        }
}

@Composable
fun <T> rememberFormFieldState(state: FormFieldState<T>) =
    remember { mutableStateOf(state) }

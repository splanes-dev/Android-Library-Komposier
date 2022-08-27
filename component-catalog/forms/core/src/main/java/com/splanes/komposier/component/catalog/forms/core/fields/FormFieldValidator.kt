package com.splanes.komposier.component.catalog.forms.core.fields

interface FormFieldValidator<T> {

    val errorMessage: String

    suspend fun validate(input: T) =
        if (isInputValid(input)) {
            Valid
        } else {
            Error(errorMessage)
        }

    suspend fun isInputValid(input: T): Boolean

    sealed interface Result
    object Valid : Result

    @JvmInline
    value class Error(val message: String) : Result
}

suspend fun <T> List<FormFieldValidator<T>>.validateAll(input: T) =
    this.map { validator -> validator.validate(input) }
        .firstOrNull { result -> result is Error } ?: FormFieldValidator.Valid

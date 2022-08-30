package com.splanes.komposier.component.catalog.forms.core.fields.text.ui

sealed interface FormTextFieldInputType {

    val id: Int

    @JvmInline
    value class Text(override val id: Int = 0) : FormTextFieldInputType

    @JvmInline
    value class Email(override val id: Int = 1) : FormTextFieldInputType

    @JvmInline
    value class Password(override val id: Int = 2) : FormTextFieldInputType

    @JvmInline
    value class Number(override val id: Int = 3) : FormTextFieldInputType
}

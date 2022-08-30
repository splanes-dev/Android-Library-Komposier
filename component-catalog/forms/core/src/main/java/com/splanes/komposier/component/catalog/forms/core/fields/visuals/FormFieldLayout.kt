package com.splanes.komposier.component.catalog.forms.core.fields.visuals

sealed interface FormFieldLayout {
    val weight: Float

    @JvmInline
    value class Fill(override val weight: Float = 1f) : FormFieldLayout

    @JvmInline
    value class Grid(override val weight: Float = .5f) : FormFieldLayout
}

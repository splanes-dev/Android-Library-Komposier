package com.splanes.komposier.component.catalog.dialogs.ui

sealed interface DialogTitleLayout {

    object Column : DialogTitleLayout

    @JvmInline
    value class Row(val isSpaceBetween: Boolean = false) : DialogTitleLayout
}

package com.splanes.komposier.component.catalog.snackbar.model

import androidx.compose.material3.SnackbarData
import androidx.compose.material3.SnackbarVisuals

interface SnackbarUiData : SnackbarData {
    val model: SnackbarUiModel
    override val visuals: SnackbarVisuals get() = model

    fun leadingIconClick()
    fun trailingIconClick()
}
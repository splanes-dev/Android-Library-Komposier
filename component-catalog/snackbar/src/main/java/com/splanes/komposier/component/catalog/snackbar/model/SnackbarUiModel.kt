package com.splanes.komposier.component.catalog.snackbar.model

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.ui.graphics.vector.ImageVector

data class SnackbarUiModel(
    override val message: String,
    override val actionLabel: String? = null,
    val leadingIcon: ImageVector? = null,
    val trailingIcon: ImageVector? = null,
    val colors: SnackbarColors = SnackbarColors.Default,
    override val duration: SnackbarDuration = SnackbarDuration.Long,
    override val withDismissAction: Boolean = duration == SnackbarDuration.Indefinite,
): SnackbarVisuals
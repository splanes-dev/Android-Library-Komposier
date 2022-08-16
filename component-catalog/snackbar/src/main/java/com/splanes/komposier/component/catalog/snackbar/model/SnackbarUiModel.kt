package com.splanes.komposier.component.catalog.snackbar.model

import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarVisuals
import androidx.compose.ui.graphics.vector.ImageVector

class SnackbarUiModel(
    val textContent: String = "",
    val leadingIcon: ImageVector? = null,
    val trailingIcon: ImageVector? = null,
    val onLeadingIconClick: () -> Unit = {},
    val onTrailingIconClick: () -> Unit = {},
    val textTrailingAction: String? = null,
    val onTrailingActionClick: () -> Unit = {},
    val colors: SnackbarColors.ColorTokens = SnackbarColors.Default,
    override val duration: SnackbarDuration = SnackbarDuration.Long,
    override val withDismissAction: Boolean = duration == SnackbarDuration.Indefinite,
): SnackbarVisuals {
    override val message: String = textContent
    override val actionLabel: String? = textTrailingAction
}
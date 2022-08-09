package com.splanes.komposier.component.snackbar.state

import androidx.compose.ui.graphics.vector.ImageVector

data class SnackbarUiModel(
    val textContent: String? = null
    val leadingIcon: ImageVector? = null,
    val trailingIcon: ImageVector? = null,
    val onLeadingIconClick: () -> Unit = {},
    val onTrailingIconClick: () -> Unit = {},
    val textTrailingAction: String? = null,
    val onTrailingActionClick: () -> Unit = {},
    val colors: SnackbarColors = SnackbarColors.Default
)


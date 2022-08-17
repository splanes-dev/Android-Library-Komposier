package com.splanes.komposier.component.catalog.snackbar.model

enum class SnackbarResults {
    ActionClick,
    LeadingIconClick,
    TrailingIconClick,
    Dismissed,
    ;

    companion object
}

inline fun SnackbarResults.handle(
    crossinline onActionClick: () -> Unit = {},
    crossinline onLeadingIconClick: () -> Unit = {},
    crossinline onTrailingIconClick: () -> Unit = {},
    crossinline onDismiss: () -> Unit = {}
) {
    when (this) {
        SnackbarResults.ActionClick -> onActionClick()
        SnackbarResults.LeadingIconClick -> onLeadingIconClick()
        SnackbarResults.TrailingIconClick -> onTrailingIconClick()
        SnackbarResults.Dismissed -> onDismiss()
    }
}
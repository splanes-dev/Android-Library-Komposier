package com.splanes.komposier.component.catalog.snackbar.ui.state

import com.splanes.komposier.component.catalog.snackbar.model.SnackbarResults
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiData
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation

internal class SnackbarUiDataImpl(
    override val model: SnackbarUiModel,
    private val continuation: CancellableContinuation<SnackbarResults>
) : SnackbarUiData {

    override fun leadingIconClick() =
        resume { SnackbarResults.LeadingIconClick }

    override fun trailingIconClick() =
        resume { SnackbarResults.TrailingIconClick }

    override fun dismiss() =
        resume { SnackbarResults.Dismissed }

    override fun performAction() =
        resume { SnackbarResults.ActionClick }

    private fun resume(result: () -> SnackbarResults) {
        continuation.takeIf { it.isActive }?.resume(result())
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as SnackbarUiDataImpl

        if (visuals != other.visuals) return false
        if (continuation != other.continuation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = visuals.hashCode()
        result = 31 * result + continuation.hashCode()
        return result
    }
}
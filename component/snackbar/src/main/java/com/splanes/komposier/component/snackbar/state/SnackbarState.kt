package com.splanes.komposier.component.snackbar.state

import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember

class SnackbarState(
    val model: SnackbarUiModel,
    val onStateChanged: (SnackbarState) -> Unit
) {
    var visible: Boolean = false

    suspend fun show(
        duration: SnackbarDuration = SnackbarDuration.Long,
    ) {

    }

    companion object {
        val Empty get() = SnackbarState()
    }
}



@Composable
fun rememberSnackbarState(): SnackbarState = remember { SnackbarState() }

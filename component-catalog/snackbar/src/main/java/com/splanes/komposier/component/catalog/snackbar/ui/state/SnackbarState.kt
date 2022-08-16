package com.splanes.komposier.component.catalog.snackbar.ui.state

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue

class SnackbarState(
    model: SnackbarUi = SnackbarUi(),
    val hostState: SnackbarHostState = SnackbarHostState(),
    val onStateChanged: (SnackbarState) -> Unit = {}
) {
    var currentModel: SnackbarUi by mutableStateOf(model)
        private set

    @OptIn(ExperimentalMaterial3Api::class)
    suspend fun show(): SnackbarResult =
        hostState.showSnackbar(visuals = currentModel)

    fun updateUiModel(updater: (from: SnackbarUi) -> SnackbarUi) {
        currentModel = updater(currentModel)
    }

    companion object {
        val Empty get() = SnackbarState()
    }
}


@Composable
fun rememberSnackbarState(state: SnackbarState = SnackbarState.Empty): SnackbarState =
    remember { state }

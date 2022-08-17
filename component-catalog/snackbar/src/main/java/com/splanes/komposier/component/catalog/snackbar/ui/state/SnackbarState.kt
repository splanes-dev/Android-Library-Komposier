package com.splanes.komposier.component.catalog.snackbar.ui.state

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarResults
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiData
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import com.splanes.komposier.component.catalog.snackbar.model.handle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class SnackbarState(private val scope: CoroutineScope) {

    private val mutex = Mutex()

    internal var snackbarUiData by mutableStateOf<SnackbarUiData?>(null)
        private set

    fun show(
        model: SnackbarUiModel,
        scope: CoroutineScope = this.scope,
        onResult: (SnackbarResults) -> Unit = {}
    ) {
        scope.launch {
            mutex.withLock {
                try {
                    suspendCancellableCoroutine { cont ->
                        snackbarUiData = SnackbarUiDataImpl(model, cont)
                    }.run(onResult)
                } finally {
                    snackbarUiData = null
                }
            }
        }
    }

    fun show(
        model: SnackbarUiModel,
        scope: CoroutineScope = this.scope,
        onActionClick: () -> Unit = {},
        onLeadingIconClick: () -> Unit = {},
        onTrailingIconClick: () -> Unit = {},
        onDismiss: () -> Unit = {}
    ) {
        show(
            model = model,
            scope = scope,
            onResult = { result ->
                result.handle(onActionClick, onLeadingIconClick, onTrailingIconClick, onDismiss)
            }
        )
    }
}


@Composable
fun rememberSnackbarState(state: SnackbarState = SnackbarState(rememberCoroutineScope())): SnackbarState =
    remember { state }

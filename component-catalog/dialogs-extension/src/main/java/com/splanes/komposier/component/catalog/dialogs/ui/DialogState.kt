package com.splanes.komposier.component.catalog.dialogs.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlin.coroutines.resume
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock

class DialogState {

    private val mutex: Mutex = Mutex()
    var currentDialogData by mutableStateOf<DialogData?>(null)
        private set

    suspend fun show(
        visuals: DialogVisuals,
        result: (DialogResult) -> Unit
    ) {
        mutex.withLock {
            try {
                suspendCancellableCoroutine { cont ->
                    currentDialogData = DialogDataImpl(visuals, cont)
                }.run(result)
            } finally {
                currentDialogData = null
            }
        }
    }

    private class DialogDataImpl(
        override val visuals: DialogVisuals,
        val continuation: CancellableContinuation<DialogResult>
    ) : DialogData {
        override fun cancel() {
            resume { DialogResult.Cancelled }
        }

        override fun dismiss() {
            resume { DialogResult.Dismissed }
        }

        override fun confirm() {
            resume { DialogResult.Confirmed }
        }

        private fun resume(result: () -> DialogResult) {
            continuation.takeIf { it.isActive }?.resume(result())
        }
    }
}

@Composable
fun rememberDialogState() = remember { DialogState() }

interface DialogData {
    val visuals: DialogVisuals

    fun cancel()

    fun dismiss()

    fun confirm()
}

@Composable
fun LaunchDialog(state: DialogState, visuals: DialogVisuals, result: (DialogResult) -> Unit) {
    val scope = rememberCoroutineScope()
    SideEffect { scope.launch { state.show(visuals, result) } }
}

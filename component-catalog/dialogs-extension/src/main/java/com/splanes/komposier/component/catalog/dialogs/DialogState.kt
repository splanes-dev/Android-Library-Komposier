package com.splanes.komposier.component.catalog.dialogs

interface DialogState<Visuals : DialogVisuals, Result : DialogResult> {

    suspend fun show(visuals: Visuals, result: (Result) -> Unit)
}

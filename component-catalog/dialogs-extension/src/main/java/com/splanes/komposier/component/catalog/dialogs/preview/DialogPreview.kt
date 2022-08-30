package com.splanes.komposier.component.catalog.dialogs.preview

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.dialogs.DialogSimple
import com.splanes.komposier.component.catalog.dialogs.ui.DialogResult
import com.splanes.komposier.component.catalog.dialogs.ui.DialogVisuals
import com.splanes.komposier.component.catalog.dialogs.ui.LayoutColumn
import com.splanes.komposier.component.catalog.dialogs.ui.LayoutRow
import com.splanes.komposier.component.catalog.dialogs.ui.LayoutRowCentered
import com.splanes.komposier.component.catalog.dialogs.ui.rememberDialogState
import com.splanes.komposier.ui.theme.AppTheme
import com.splanes.komposier.ui.theme.defaults.DefaultColors
import com.splanes.komposier.ui.theme.defaults.DefaultShapes
import com.splanes.komposier.ui.theme.defaults.DefaultTextStyles
import kotlinx.coroutines.launch
import timber.log.Timber

private fun logResult(result: DialogResult) {
    if (Timber.treeCount == 0) {
        Timber.plant(Timber.DebugTree())
    }
    Timber.d("Dialog result: ${result.name}")
}

@Composable
private fun DialogPreviewScaffold(dialogs: List<Pair<String, DialogVisuals>>) {
    AppTheme.withProviderOf(
        colors = DefaultColors.random(),
        textStyles = DefaultTextStyles.ApercuQuicksans,
        shapes = DefaultShapes.Rounded
    )
    AppTheme.Theme {
        val dialogState = rememberDialogState()
        val scope = rememberCoroutineScope()
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(1f))
            dialogs.forEachIndexed { index, (button, visuals) ->
                if (index != 0) {
                    Spacer(modifier = Modifier.height(12.dp))
                }
                Button(onClick = {
                    scope.launch {
                        dialogState.show(visuals = visuals, result = ::logResult)
                    }
                }) { Text(button) }
            }
            Spacer(modifier = Modifier.weight(1f))
        }
        DialogSimple(state = dialogState)
    }
}

@Composable
@Preview(name = "Dialog Preview Sample1")
private fun DialogsMinData() {
    val visuals = listOf(
        "Min Content - Short" to DialogVisuals(
            content = DialogContentShort,
            confirmButtonText = DialogConfirm
        ),
        "Min Content - Medium" to DialogVisuals(
            content = DialogContentMedium,
            confirmButtonText = DialogConfirm
        ),
        "Min Content - Large" to DialogVisuals(
            content = DialogContentLarge,
            confirmButtonText = DialogConfirm
        )
    )
    DialogPreviewScaffold(visuals)
}

@Composable
@Preview(name = "Dialog Preview Sample 2")
private fun DialogsWithTitle() {
    val visuals = listOf(
        "Colum" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutColumn,
            content = DialogContentShort,
            confirmButtonText = DialogConfirm
        ),
        "Row + Centered" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutRow,
            content = DialogContentLarge,
            confirmButtonText = DialogConfirm
        ),
        "Row + Start" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutRowCentered,
            content = DialogContentShort,
            confirmButtonText = DialogConfirm
        ),
    )
    DialogPreviewScaffold(visuals)
}

@Composable
@Preview(name = "Dialog Preview Sample 3")
private fun DialogsWithTitleIcon() {
    val visuals = listOf(
        "Colum" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutColumn,
            icon = DialogIcon,
            content = DialogContentShort,
            confirmButtonText = DialogConfirm
        ),
        "Row - Start" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutRow,
            icon = DialogIcon,
            content = DialogContentLarge,
            confirmButtonText = DialogConfirm
        ),
        "Row + Centered" to DialogVisuals(
            title = DialogTitle,
            titleLayout = DialogVisuals.LayoutRowCentered,
            icon = DialogIcon,
            content = DialogContentShort,
            confirmButtonText = DialogConfirm
        ),
    )
    DialogPreviewScaffold(visuals)
}

private const val DialogTitle = "Confirmation"
private val DialogIcon = Icons.Rounded.ErrorOutline
private const val DialogContentShort = "Hello, this is a short content!"
private const val DialogContentMedium: String =
    "$DialogContentShort\n$DialogContentShort\n$DialogContentShort"
private const val DialogContentLarge: String = "$DialogContentMedium\n$DialogContentMedium"
private const val DialogConfirm = "Done"
private const val DialogDismiss = "Cancel"

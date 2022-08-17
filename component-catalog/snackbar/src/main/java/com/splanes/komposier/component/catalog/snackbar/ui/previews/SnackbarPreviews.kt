package com.splanes.komposier.component.catalog.snackbar.ui.previews

import android.content.Context
import android.content.res.Configuration
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarColors
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import com.splanes.komposier.component.catalog.snackbar.ui.state.rememberSnackbarState
import com.splanes.komposier.component.catalog.snackbar.ui.view.Snackbar
import com.splanes.komposier.component.catalog.snackbar.ui.view.SnackbarHost
import com.splanes.komposier.uitheme.theme.AppTheme
import com.splanes.komposier.uitheme.theme.Colors
import com.splanes.komposier.uitheme.theme.defaults.DefaultColors
import com.splanes.komposier.uitheme.theme.defaults.DefaultShapes
import com.splanes.komposier.uitheme.theme.defaults.DefaultTextStyles
import timber.log.Timber

@Composable
private fun toastState(): ToastState = ToastState(LocalContext.current)

private class ToastState(val context: Context) {
    fun show(text: () -> String) {
        Timber.plant(Timber.DebugTree())
        Timber.v("Click done -> ${text()}")
        Toast.makeText(context, "${text()} Clicked", Toast.LENGTH_LONG).show()
    }
}

private fun snackbarUiModelSample(
    actionLabel: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    colors: SnackbarColors = SnackbarColors.Default
) = SnackbarUiModel(
    message = "This is a snackbar component!",
    actionLabel = actionLabel,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    colors = colors,
    duration = SnackbarDuration.Long
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SnackbarPreview(model: SnackbarUiModel) {
    val snackbarState = rememberSnackbarState()
    val toastState = toastState()
    AppTheme.withProviderOf(
        colors = DefaultColors.Red,
        textStyles = DefaultTextStyles.ApercuQuicksans,
        shapes = DefaultShapes.Rounded
    )
    AppTheme.Theme {
        Scaffold(
            containerColor = Colors.primaryContainer,
            snackbarHost = { SnackbarHost(snackbarState = snackbarState) }
        ) { paddings ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddings),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = {
                        snackbarState.show(
                            model = model,
                            onActionClick = { toastState.show { "Action" } },
                            onLeadingIconClick = { toastState.show { "Leading icon" } },
                            onTrailingIconClick = { toastState.show { "Trailing icon" } },
                            onDismiss = { toastState.show { "Dismiss" } }
                        )
                    }
                ) {
                    Text(text = "Show snackbar")
                }
            }
        }
    }
}

@Composable
@Preview(
    name = "Snackbar No Icons",
    group = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
private fun SimpleLight() {
    SnackbarPreview(model = snackbarUiModelSample())
}

@Composable
@Preview(
    name = "Snackbar No Icons",
    group = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
private fun SimpleDark() {
    SnackbarPreview(model = snackbarUiModelSample())
}

@Composable
@Preview(
    name = "Snackbar Leading Icons",
    group = "Light",
    uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
private fun LeadingIconLight() {
    SnackbarPreview(model = snackbarUiModelSample(leadingIcon = Icons.Rounded.Build))
}

@Composable
@Preview(
    name = "Snackbar Leading Icons",
    group = "Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL,
    showSystemUi = true
)
private fun LeadingIconDark() {
    SnackbarPreview(model = snackbarUiModelSample(leadingIcon = Icons.Rounded.Build))
}
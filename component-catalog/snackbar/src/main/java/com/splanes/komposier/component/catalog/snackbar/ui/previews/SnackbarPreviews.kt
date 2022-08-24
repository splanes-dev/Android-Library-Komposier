package com.splanes.komposier.component.catalog.snackbar.ui.previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Share
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarColors
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import com.splanes.komposier.component.catalog.snackbar.ui.state.rememberSnackbarState
import com.splanes.komposier.component.catalog.snackbar.ui.view.SnackbarHost
import com.splanes.komposier.ui.theme.AppTheme
import com.splanes.komposier.ui.theme.Colors
import com.splanes.komposier.ui.theme.defaults.DefaultColors
import com.splanes.komposier.ui.theme.defaults.DefaultShapes
import com.splanes.komposier.ui.theme.defaults.DefaultTextStyles
import timber.log.Timber

private fun logClick(action: () -> String) {
    if (Timber.treeCount == 0) {
        Timber.plant(Timber.DebugTree())
    }
    Timber.d("${action()} Clicked")
}

private fun snackbarUiModelSample(
    actionLabel: String? = null,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    colors: SnackbarColors = SnackbarColors.Default,
    duration: SnackbarDuration = SnackbarDuration.Indefinite
) = SnackbarUiModel(
    message = "This is a snackbar component!",
    actionLabel = actionLabel,
    leadingIcon = leadingIcon,
    trailingIcon = trailingIcon,
    colors = colors,
    duration = duration
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SnackbarPreview(model: SnackbarUiModel) {
    val snackbarState = rememberSnackbarState()
    AppTheme.withProviderOf(
        colors = DefaultColors.random(),
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
                            onActionClick = { logClick { "Action" } },
                            onLeadingIconClick = { logClick { "Leading icon" } },
                            onTrailingIconClick = { logClick { "Trailing icon" } },
                            onDismiss = { logClick { "Dismiss" } }
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
@Preview(name = "Snackbar No Icons")
private fun SimpleLight() {
    SnackbarPreview(model = snackbarUiModelSample())
}

@Composable
@Preview(name = "Snackbar Leading Icons")
private fun LeadingIconLight() {
    SnackbarPreview(model = snackbarUiModelSample(leadingIcon = Icons.Rounded.Star))
}

@Composable
@Preview(name = "Snackbar Trailing Icons")
private fun TrailingIconLight() {
    SnackbarPreview(model = snackbarUiModelSample(trailingIcon = Icons.Rounded.Star))
}

@Composable
@Preview(name = "Snackbar Leading&Trailing Icons")
private fun LeadingTrailingIconLight() {
    SnackbarPreview(
        model = snackbarUiModelSample(
            leadingIcon = Icons.Rounded.Star,
            trailingIcon = Icons.Rounded.Share,
        )
    )
}

@Composable
@Preview(name = "Snackbar Leading&Action Icons")
private fun LeadingIconActionLight() {
    SnackbarPreview(
        model = snackbarUiModelSample(
            leadingIcon = Icons.Rounded.Star,
            actionLabel = "Share!"
        )
    )
}

@Composable
@Preview(name = "Snackbar Success")
private fun SuccessLight() {
    SnackbarPreview(
        model = snackbarUiModelSample(colors = SnackbarColors.Success)
    )
}

@Composable
@Preview(name = "Snackbar Warning")
private fun WarningLight() {
    SnackbarPreview(
        model = snackbarUiModelSample(colors = SnackbarColors.Warning)
    )
}

@Composable
@Preview(name = "Snackbar Info")
private fun InfoLight() {
    SnackbarPreview(
        model = snackbarUiModelSample(colors = SnackbarColors.Info)
    )
}
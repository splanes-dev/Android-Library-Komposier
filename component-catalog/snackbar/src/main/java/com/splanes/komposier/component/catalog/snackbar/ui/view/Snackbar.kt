package com.splanes.komposier.component.catalog.snackbar.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.splanes.komposier.commons.defaults.orDefault
import com.splanes.komposier.commons.scope.ifNoneNull
import com.splanes.komposier.commons.scope.ifNotNull
import com.splanes.komposier.commons.scope.ifThenOrNull
import com.splanes.komposier.component.catalog.snackbar.state.SnackbarState
import com.splanes.komposier.component.catalog.snackbar.state.SnackbarUi
import com.splanes.komposier.component.catalog.snackbar.state.rememberSnackbarState
import com.splanes.komposier.uitheme.resources.dp
import com.splanes.komposier.uitheme.theme.Shapes
import com.splanes.komposier.uitheme.theme.TextStyles

@Composable
fun Snackbar(
    modifier: Modifier = Modifier,
    state: SnackbarState = rememberSnackbarState(),
) {
    SnackbarHost(
        modifier = modifier,
        hostState = state.hostState,
        snackbar = { data ->
            when (val uiModel = data.visuals) {
                is SnackbarUi -> {
                    SnackbarComponent(uiModel)
                }
            }
        }
    )
}

@Composable
internal fun SnackbarComponent(model: SnackbarUi) {
    androidx.compose.material3.Snackbar(
        action = model.actionLabel.ifNotNull { { SnackbarActionButton() } },
        dismissAction = ifThenOrNull(model.withDismissAction) { { SnackbarDismissButton() } }, // TODO()
        shape = Shapes.medium,
        containerColor = model.colors.containerColor(),
        contentColor = model.colors.contentColor(),
        actionContentColor = model.colors.trailingActionColor(),
        dismissActionContentColor = model.colors.trailingActionColor()
    ) {
        Row(
            horizontalArrangement = model.contentHorizontalArrangement(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            model.leadingIcon.ifNotNull {
                SnackbarContentIcon(
                    icon = this
                )
            }
            SnackbarContentText()
            model.trailingIcon.ifNotNull {
                SnackbarContentIcon()
            }
        }
    }
}

@Composable
internal fun SnackbarActionButton() {

}

@Composable
internal fun SnackbarDismissButton() {

}

@Composable
internal fun SnackbarContentIcon(
    modifier: Modifier,
    icon: ImageVector,
    color: Color,
    onClick: (() -> Unit)?
) {
    IconButton(
        modifier = modifier,
        onClick = onClick.orDefault(),
        colors = color.findIconButtonColors()
    ) {
        Icon(
            modifier = Modifier.size(dp { 32 }),
            imageVector = icon,
            contentDescription = null,
        )
    }
}

@Composable
internal fun RowScope.SnackbarContentText(
    modifier: Modifier,
    contentText: String,
    color: Color,
) {
    Text(
        modifier = modifier.weight(1f),
        text = contentText,
        color = color,
        style = TextStyles.titleSmall
    )
}

internal fun SnackbarUi.contentHorizontalArrangement() =
    ifNoneNull(leadingIcon, trailingIcon) { Arrangement.SpaceAround } ?: Arrangement.Start

@Composable
internal fun Color.findIconButtonColors(): IconButtonColors = IconButtonDefaults.
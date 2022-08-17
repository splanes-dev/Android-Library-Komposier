package com.splanes.komposier.component.catalog.snackbar.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import com.splanes.komposier.component.catalog.snackbar.R
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiData
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import com.splanes.komposier.component.catalog.snackbar.tokens.SnackbarTokens
import com.splanes.komposier.uitheme.theme.Paddings
import com.splanes.komposier.uitheme.theme.tokens.color
import com.splanes.komposier.uitheme.theme.tokens.shape
import com.splanes.komposier.uitheme.theme.tokens.typography.textStyle

@Composable
internal fun Snackbar(data: SnackbarUiData) {
    with(data.model) {
        androidx.compose.material3.Snackbar(
            modifier = Modifier
                .fillMaxWidth()
                .height(SnackbarTokens.SingleLineContainerHeight),
            action = actionLabel?.let { label ->
                {
                    SnackbarActionButton(
                        text = label,
                        color = colors.content.color(),
                        style = SnackbarTokens.ContentTextStyle.textStyle(),
                        onClick = data::performAction
                    )
                }
            },
            dismissAction = if (withDismissAction) {
                {
                    SnackbarDismissButton(
                        color = colors.content.color(),
                        style = SnackbarTokens.ContentTextStyle.textStyle(),
                        onClick = data::dismiss
                    )
                }
            } else {
                null
            },
            shape = SnackbarTokens.ContainerShape.shape(),
            containerColor = colors.container.color(),
            contentColor = colors.content.color(),
            actionContentColor = colors.content.color(),
            dismissActionContentColor = colors.content.color()
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = contentHorizontalArrangement(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                if (leadingIcon != null) {
                    SnackbarContentIcon(
                        modifier = Modifier.size(SnackbarTokens.IconSize),
                        icon = leadingIcon,
                        color = colors.icon.color(),
                        onClick = data::leadingIconClick
                    )
                }
                Text(
                    modifier = Modifier
                        .weight(1f)
                        .wrapContentHeight()
                        .align(Alignment.CenterVertically),
                    text = message,
                    color = colors.content.color(),
                    style = SnackbarTokens.ContentTextStyle.textStyle(),
                    textAlign = TextAlign.Justify
                )
                if (trailingIcon != null && actionLabel == null) {
                    SnackbarContentIcon(
                        modifier = Modifier.size(SnackbarTokens.IconSize),
                        icon = trailingIcon,
                        color = colors.icon.color(),
                        onClick = data::trailingIconClick
                    )
                }
            }
        }
    }
}

@Composable
internal fun SnackbarActionButton(
    text: String,
    color: Color,
    style: TextStyle,
    onClick: () -> Unit
) {
    OutlinedButton(
        modifier = Modifier
            .wrapContentSize()
            .padding(Paddings.mediumSmall),
        onClick = onClick,
        colors = ButtonDefaults.outlinedButtonColors(contentColor = color),
        content = { Text(text = text, style = style) }
    )
}

@Composable
internal fun SnackbarDismissButton(
    color: Color,
    style: TextStyle,
    onClick: () -> Unit
) {
    TextButton(
        modifier = Modifier
            .wrapContentSize()
            .padding(Paddings.mediumSmall),
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = color),
        content = { Text(text = stringResource(id = R.string.snackbar_dismiss_action), style = style) }
    )
}

@Composable
internal fun SnackbarContentIcon(
    modifier: Modifier,
    icon: ImageVector,
    color: Color,
    onClick: () -> Unit
) {
    IconButton(
        modifier = Modifier
            .wrapContentSize()
            .padding(Paddings.small),
        onClick = onClick,
        colors = IconButtonDefaults.iconButtonColors(contentColor = color)
    ) {
        Icon(
            modifier = modifier,
            imageVector = icon,
            contentDescription = null,
        )
    }
}


internal fun SnackbarUiModel.contentHorizontalArrangement() =
    if (leadingIcon != null && (trailingIcon != null || actionLabel != null)) {
        Arrangement.SpaceBetween
    } else {
        Arrangement.Start
    }
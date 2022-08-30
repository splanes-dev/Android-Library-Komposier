package com.splanes.komposier.component.catalog.dialogs

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.dialogs.defaults.DialogDefaults
import com.splanes.komposier.component.catalog.dialogs.tokens.DialogTokens
import com.splanes.komposier.component.catalog.dialogs.ui.DialogColors
import com.splanes.komposier.component.catalog.dialogs.ui.DialogState
import com.splanes.komposier.component.catalog.dialogs.ui.DialogTitleLayout
import com.splanes.komposier.component.catalog.dialogs.ui.DialogVisuals
import com.splanes.komposier.ui.theme.tokens.toColor
import com.splanes.komposier.ui.theme.tokens.typography.toTextStyle
import com.splanes.komposier.ui.toolkit.anims.transitions.orNone

@Composable
fun DialogSimple(
    state: DialogState,
    modifier: Modifier = Modifier,
    shape: Shape = DialogDefaults.shape,
    colors: DialogColors = DialogDefaults.dialogColors()
) {
    val data = state.currentDialogData
    AnimatedVisibility(
        modifier = modifier,
        visible = data != null,
        enter = data?.visuals?.transition?.enter.orNone(),
        exit = data?.visuals?.transition?.exit.orNone()
    ) {
        data?.run {
            AlertDialog(
                onDismissRequest = data::cancel,
                confirmButton = {
                    DialogButton(
                        text = visuals.confirmButtonText,
                        isConfirmButton = true,
                        onClick = data::confirm
                    )
                },
                dismissButton = visuals.dismissButtonText?.let { text ->
                    { DialogButton(text = text, isConfirmButton = false, onClick = data::dismiss) }
                },
                icon = visuals.icon
                    ?.takeUnless { visuals.titleLayout is DialogTitleLayout.Row }
                    ?.let {
                        {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                if (visuals.isCentered()) Spacer(modifier = Modifier.weight(1f))
                                DialogIcon(visuals = visuals)
                                if (visuals.isCentered()) Spacer(modifier = Modifier.weight(1f))
                            }
                        }
                    },
                title = visuals.title?.let { text ->
                    {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            if (visuals.titleLayout is DialogTitleLayout.Row) {
                                DialogIcon(visuals = visuals)
                            }
                            if (visuals.isCentered()) Spacer(modifier = Modifier.weight(1f))
                            Text(
                                text = text,
                                style = DialogTokens.SubheadFont.toTextStyle()
                            )
                            if (visuals.isCentered()) Spacer(modifier = Modifier.weight(1f))
                        }
                    }
                },
                text = {
                    Text(
                        text = visuals.content,
                        style = DialogTokens.SupportingTextFont.toTextStyle()
                    )
                },
                shape = shape,
                containerColor = colors.container,
                tonalElevation = visuals.elevation,
                iconContentColor = colors.icon,
                titleContentColor = colors.title,
                textContentColor = colors.text,
                properties = visuals.properties
            )
        }
    }
}

@Composable
internal fun DialogIcon(visuals: DialogVisuals) {
    visuals.icon?.let { imageVector ->
        Icon(
            modifier = Modifier.size(visuals.iconSize),
            imageVector = imageVector,
            contentDescription = visuals.title,
            tint = DialogTokens.IconColor.toColor()
        )
    }
}

@Composable
internal fun DialogButton(
    text: String,
    isConfirmButton: Boolean,
    onClick: () -> Unit
) {
    if (isConfirmButton) {
        Button(onClick = onClick) {
            Text(
                text = text,
                style = DialogDefaults.buttonTextStyle
            )
        }
    } else {
        OutlinedButton(
            onClick = onClick,
            border = BorderStroke(.75.dp, MaterialTheme.colorScheme.primary)
        ) {
            Text(
                text = text,
                style = DialogDefaults.buttonTextStyle
            )
        }
    }
}

private fun DialogVisuals.isCentered() =
    titleLayout !is DialogTitleLayout.Row || titleLayout.isSpaceBetween

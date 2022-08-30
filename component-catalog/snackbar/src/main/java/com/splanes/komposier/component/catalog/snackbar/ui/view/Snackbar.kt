package com.splanes.komposier.component.catalog.snackbar.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandHorizontally
import androidx.compose.animation.fadeIn
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.HighlightOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiData
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiModel
import com.splanes.komposier.component.catalog.snackbar.tokens.SnackbarTokens
import com.splanes.komposier.ui.theme.Paddings
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.toColor
import com.splanes.komposier.ui.theme.tokens.toShape
import com.splanes.komposier.ui.theme.tokens.typography.toTextStyle
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
internal fun Snackbar(data: SnackbarUiData) {
    SnackbarScaffold(data) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = Paddings.small)
                .clickable(
                    interactionSource = MutableInteractionSource(),
                    indication = null
                ) {
                    data.dismiss()
                },
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically
        ) {
            if (leadingIcon != null) {
                SnackbarContentIcon(
                    modifier = Modifier.size(SnackbarTokens.IconSize),
                    icon = leadingIcon,
                    color = colors.icon.toColor(),
                    onClick = data::leadingIconClick
                )
            }
            Text(
                modifier = Modifier
                    .weight(1f)
                    .wrapContentHeight()
                    .align(Alignment.CenterVertically)
                    .padding(
                        start = if (leadingIcon == null) Paddings.large else 0.dp
                    ),
                text = message,
                color = colors.content.toColor(),
                style = SnackbarTokens.ContentTextStyle.toTextStyle(),
                textAlign = TextAlign.Justify
            )
            when {
                actionLabel != null -> {
                    SnackbarActionButton(
                        text = actionLabel,
                        containerColor = colors.content.toColor().copy(alpha = .25f),
                        contentColor = colors.content.toColor(),
                        style = SnackbarTokens.ContentTextStyle.toTextStyle(),
                        onClick = data::performAction
                    )
                }
                trailingIcon != null -> {
                    SnackbarContentIcon(
                        modifier = Modifier.size(SnackbarTokens.IconSize),
                        icon = trailingIcon,
                        color = colors.icon.toColor(),
                        onClick = data::trailingIconClick
                    )
                }
            }
        }
    }
}

@Composable
internal fun SnackbarScaffold(data: SnackbarUiData, snackbarContent: @Composable SnackbarUiModel.() -> Unit) {
    var isSpacerBeforeDismissVisible by remember { mutableStateOf(false) }
    var isDismissButtonVisible by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(modifier = Modifier.width(SnackbarTokens.ContainerHorizontalPaddings))

        Surface(
            modifier = Modifier
                .weight(1f)
                .height(data.model.containerHeight()),
            shape = SnackbarTokens.ContainerShape.toShape(),
            color = data.model.colors.container.toColor(),
            contentColor = data.model.colors.content.toColor(),
        ) {
            snackbarContent(data.model)
        }

        SnackbarSpacerBeforeDismiss(visible = isSpacerBeforeDismissVisible)

        SnackbarDismissButton(
            visible = isDismissButtonVisible,
            onClick = data::dismiss,
            onTransitionEnd = { isSpacerBeforeDismissVisible = isDismissButtonVisible }
        )

        if (data.model.duration > SnackbarDuration.Short) {
            val scope = rememberCoroutineScope()
            LaunchedEffect(isDismissButtonVisible) {
                scope.launch {
                    delay(SnackbarTokens.DismissButtonDelay)
                    isDismissButtonVisible = true
                }
            }
        }
    }
}

@Composable
internal fun SnackbarSpacerBeforeDismiss(visible: Boolean) {
    val width by animateDpAsState(
        targetValue = if (visible) {
            SnackbarTokens.DismissButtonHorizontalPadding
        } else {
            SnackbarTokens.ContainerHorizontalPaddings
        },
        animationSpec = spring(dampingRatio = Spring.DampingRatioMediumBouncy, stiffness = Spring.StiffnessMedium)
    )
    Spacer(modifier = Modifier.width(width))
}

@Composable
internal fun SnackbarDismissButton(visible: Boolean, onClick: () -> Unit, onTransitionEnd: () -> Unit) {
    AnimatedVisibility(
        visible = visible,
        enter = expandHorizontally(animationSpec = tween(durationMillis = 300)) +
                fadeIn(animationSpec = tween(durationMillis = 450))
    ) {
        IconButton(
            modifier = Modifier
                .wrapContentSize()
                .padding(horizontal = SnackbarTokens.DismissButtonHorizontalPadding),
            onClick = onClick,
            colors = IconButtonDefaults.iconButtonColors(contentColor = ColorSchemeTokens.OnSurface.toColor())
        ) {
            Icon(
                modifier = Modifier.size(SnackbarTokens.DismissButtonSize),
                imageVector = Icons.Rounded.HighlightOff,
                contentDescription = null,
            )
        }
        onTransitionEnd()
    }
}

@Composable
internal fun SnackbarActionButton(
    text: String,
    containerColor: Color,
    contentColor: Color,
    style: TextStyle,
    onClick: () -> Unit
) {
    Button(
        modifier = Modifier
            .wrapContentSize()
            .padding(horizontal = Paddings.mediumLarge),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = containerColor,
            contentColor = contentColor
        ),
        content = { Text(text = text, style = style) }
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
            .padding(horizontal = Paddings.mediumSmall),
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

private fun SnackbarUiModel.containerHeight() = if (actionLabel == null && !withDismissAction) {
    SnackbarTokens.SingleLineContainerHeight
} else {
    SnackbarTokens.TwoLinesContainerHeight
}

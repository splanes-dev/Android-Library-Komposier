package com.splanes.komposier.component.catalog.buttons

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.ui.ButtonColors
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize
import com.splanes.komposier.ui.theme.AppTheme
import com.splanes.komposier.ui.theme.defaults.DefaultColors
import com.splanes.komposier.ui.theme.defaults.DefaultShapes
import com.splanes.komposier.ui.theme.defaults.DefaultTextStyles
import com.splanes.komposier.ui.toolkit.configuration.layoutDirection
import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization
import com.splanes.komposier.ui.toolkit.texts.capitalization.capitalize
import timber.log.Timber

@Composable
internal fun ButtonIcon(
    buttonIcon: ButtonIcon,
    colors: ButtonColors,
    enabled: Boolean,
    description: String
) {
    Icon(
        modifier = androidx.compose.ui.Modifier
            .padding(buttonIcon.horizontalPadding)
            .size(buttonIcon.size),
        imageVector = buttonIcon.icon,
        tint = colors.iconColor(enabled = enabled).value,
        contentDescription = description
    )
}

@Composable
internal fun RowScope.ButtonContentText(
    text: String,
    capitalization: Capitalization,
    size: ButtonSize,
    colors: ButtonColors,
    enabled: Boolean
) {
    val width = ButtonDefaults.buttonWidth(size = size)
    Text(
        modifier = Modifier
            .let { m ->
                when (width) {
                    0.dp,
                    Dp.Unspecified -> m.wrapContentWidth()
                    Dp.Infinity -> m.weight(.8f)
                    else -> m.widthIn(min = width)
                }
            }
            .align(Alignment.CenterVertically),
        text = text.capitalize(capitalization),
        textAlign = TextAlign.Center,
        style = ButtonDefaults.buttonTextStyle(size),
        color = colors.contentColor(enabled = enabled).value
    )
}

@Composable
internal fun ButtonStartSpacer(padding: PaddingValues, offset: Dp) {
    ButtonInternalSpacer(padding::calculateStartPadding, offset)
}

@Composable
internal fun ButtonEndSpacer(padding: PaddingValues, offset: Dp) {
    ButtonInternalSpacer(padding::calculateEndPadding, offset)
}

@Composable
private fun ButtonInternalSpacer(function: Function1<LayoutDirection, Dp>, offset: Dp) {
    Spacer(modifier = Modifier.width(width = function(layoutDirection()) + offset))
}

internal fun logClick() {
    if (Timber.treeCount == 0) Timber.plant(Timber.DebugTree())
    Timber.v("Button Clicked")
}

@Composable
internal fun ButtonPreviewScaffold(
    alignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    content: @Composable ColumnScope.() -> Unit
) {
    AppTheme.withProviderOf(
        colors = DefaultColors.random(),
        textStyles = DefaultTextStyles.ApercuQuicksans,
        shapes = DefaultShapes.Rounded
    )
    AppTheme.Theme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
                .background(color = MaterialTheme.colorScheme.primaryContainer),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = alignment
        ) {
            Spacer(modifier = Modifier.weight(1f))
            content()
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}
package com.splanes.komposier.component.catalog.dialogs.defaults

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandIn
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ErrorOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import com.splanes.komposier.component.catalog.dialogs.R
import com.splanes.komposier.component.catalog.dialogs.tokens.DialogTokens
import com.splanes.komposier.component.catalog.dialogs.ui.DialogColors
import com.splanes.komposier.component.catalog.dialogs.ui.DialogVisuals
import com.splanes.komposier.ui.theme.tokens.toColor
import com.splanes.komposier.ui.theme.tokens.toShape
import com.splanes.komposier.ui.theme.tokens.typography.toTextStyle

object DialogDefaults {
    val shape: Shape @Composable get() = DialogTokens.ContainerShape.toShape()
    val buttonTextStyle: TextStyle @Composable get() = DialogTokens.ActionLabelTextFont.toTextStyle()
    val containerColor: Color @Composable get() = DialogTokens.ContainerColor.toColor()
    val iconContentColor: Color @Composable get() = DialogTokens.IconColor.toColor()
    val titleContentColor: Color @Composable get() = DialogTokens.SubheadColor.toColor()
    val textContentColor: Color @Composable get() = DialogTokens.SupportingTextColor.toColor()
    val TonalElevation: Dp = DialogTokens.ContainerElevation
    val EnterAnim: EnterTransition =
        fadeIn(
            animationSpec = tween(durationMillis = TransitionDuration)
        ) + expandIn(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium
            ),
            expandFrom = Alignment.Center
        )
    val ExitAnim: ExitTransition =
        fadeOut(
            animationSpec = tween(durationMillis = TransitionDuration)
        ) + shrinkOut(
            animationSpec = spring(
                dampingRatio = Spring.DampingRatioMediumBouncy,
                stiffness = Spring.StiffnessMedium
            ),
            shrinkTowards = Alignment.Center
        )
    val IconSize: Dp by lazy { DialogTokens.IconSize }

    @Composable
    fun dialogColors(
        containerColor: Color = DialogDefaults.containerColor,
        iconContentColor: Color = DialogDefaults.iconContentColor,
        titleContentColor: Color = DialogDefaults.titleContentColor,
        textContentColor: Color = DialogDefaults.textContentColor
    ) = object : DialogColors {
        override val container: Color = containerColor
        override val title: Color = titleContentColor
        override val icon: Color = iconContentColor
        override val text: Color = textContentColor
    }

    @Composable
    fun dialogErrorVisuals(
        content: String = stringResource(id = R.string.error_dialog_message),
        okButton: String = stringResource(id = R.string.error_dialog_button),
        title: String = stringResource(id = R.string.error_dialog_title),
        icon: ImageVector = Icons.Rounded.ErrorOutline
    ) = DialogVisuals(
        content = content,
        confirmButtonText = okButton,
        title = title,
        icon = icon
    )
}

private const val TransitionDuration = 500

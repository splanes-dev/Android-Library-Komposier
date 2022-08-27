package com.splanes.komposier.component.catalog.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.component.catalog.buttons.filled.tokens.FilledButtonTokens
import com.splanes.komposier.component.catalog.buttons.filled.ui.FilledButtonUi
import com.splanes.komposier.component.catalog.buttons.flat.tokens.FlatButtonTokens
import com.splanes.komposier.component.catalog.buttons.icon.tokens.IconButtonTokens
import com.splanes.komposier.component.catalog.buttons.outlined.tokens.OutlinedButtonTokens
import com.splanes.komposier.component.catalog.buttons.outlined.ui.OutlinedButtonUi
import com.splanes.komposier.component.catalog.buttons.text.tokens.TextButtonTokens
import com.splanes.komposier.component.catalog.buttons.ui.ButtonColors
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ui.ButtonSize
import com.splanes.komposier.ui.theme.TextStyles
import com.splanes.komposier.ui.theme.tokens.shape
import com.splanes.komposier.ui.toolkit.resources.sp.minus
import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization
import androidx.compose.material3.ButtonDefaults as MaterialButtonDefaults

object ButtonDefaults {

    private inline fun buttonColors(
        crossinline icon: @Composable (Boolean) -> Color,
        crossinline border: @Composable (Boolean) -> Color,
        crossinline container: @Composable (Boolean) -> Color,
        crossinline content: @Composable (Boolean) -> Color
    ): ButtonColors = object : ButtonColors {
        @Composable
        override fun iconColor(enabled: Boolean): State<Color> =
            rememberUpdatedState(newValue = icon(enabled))

        @Composable
        override fun borderColor(enabled: Boolean): State<Color> =
            rememberUpdatedState(newValue = border(enabled))

        @Composable
        override fun containerColor(enabled: Boolean): State<Color> =
            rememberUpdatedState(newValue = container(enabled))

        @Composable
        override fun contentColor(enabled: Boolean): State<Color> =
            rememberUpdatedState(newValue = content(enabled))
    }

    @Composable
    internal fun ButtonTokens.buttonColors() = buttonColors(
        icon = { enabled -> if (enabled) buttonIconColor() else buttonIconDisabledColor() },
        border = { enabled -> if (enabled) buttonBorderColor() else buttonBorderDisabledColor() },
        container = { enabled -> if (enabled) buttonContainerColor() else buttonContainerDisabledColor() },
        content = { enabled -> if (enabled) buttonContentColor() else buttonContentDisabledColor() }
    )

    @Composable
    internal fun ButtonTokens.buttonElevation(): ButtonElevation = MaterialButtonDefaults.buttonElevation(
        defaultElevation = ButtonDefaultElevation,
        pressedElevation = ButtonPressedElevation,
        focusedElevation = ButtonFocusedElevation,
        hoveredElevation = ButtonHoveredElevation,
        disabledElevation = ButtonDisabledElevation
    )

    val FilledButtonColors: ButtonColors
        @Composable
        get() = FilledButtonTokens.buttonColors()

    val OutlinedButtonColors: ButtonColors
        @Composable
        get() = OutlinedButtonTokens.buttonColors()

    val FlatButtonColors: ButtonColors
        @Composable
        get() = FlatButtonTokens.buttonColors()

    val IconButtonColors: ButtonColors
        @Composable
        get() = IconButtonTokens.buttonColors()

    val TextButtonColors: ButtonColors
        @Composable
        get() = TextButtonTokens.Text.buttonColors()

    val LinkButtonColors: ButtonColors
        @Composable
        get() = TextButtonTokens.Link.buttonColors()

    val FilledButtonElevation: ButtonElevation
        @Composable
        get() = FilledButtonTokens.buttonElevation()

    val FilledButtonShape: Shape
        @Composable
        get() = FilledButtonTokens.ButtonShape.shape()

    val OutlinedButtonElevation: ButtonElevation
        @Composable
        get() = OutlinedButtonTokens.buttonElevation()

    val OutlinedButtonShape: Shape
        @Composable
        get() = OutlinedButtonTokens.ButtonShape.shape()

    @Composable
    fun filledButton(
        text: String,
        icon: ButtonIcon? = null,
        size: ButtonSize = ButtonSize.Wrap,
        capitalization: Capitalization = Capitalization.Words,
        enabled: Boolean = true,
        padding: PaddingValues = FilledButtonTokens.ButtonContentPadding
    ): FilledButtonUi = FilledButtonUi(
        text = text,
        buttonIcon = icon,
        size = size,
        capitalization = capitalization,
        enabled = enabled,
        paddings = padding
    )

    @Composable
    fun outlinedButton(
        text: String,
        icon: ButtonIcon? = null,
        size: ButtonSize = ButtonSize.Wrap,
        capitalization: Capitalization = Capitalization.Words,
        enabled: Boolean = true,
        padding: PaddingValues = OutlinedButtonTokens.ButtonContentPadding
    ): OutlinedButtonUi = OutlinedButtonUi(
        text = text,
        buttonIcon = icon,
        size = size,
        capitalization = capitalization,
        enabled = enabled,
        paddings = padding
    )

    @Composable
    fun iconButton(
        icon: ImageVector,
        size: Dp = ButtonTokens.ButtonIconSize,
        horizontalPadding: PaddingValues = ButtonTokens.ButtonIconPadding,
        position: ButtonIcon.RelativePosition = ButtonIcon.Leading
    ) = ButtonIcon.buttonIconOf(
        icon = icon,
        size = size,
        horizontalPadding = horizontalPadding,
        position = position
    )

    fun buttonHeight(size: ButtonSize) = ButtonTokens.run {
        if (size == ButtonSize.Small) ButtonHeightSmall else ButtonHeight
    }

    fun buttonPadding(size: ButtonSize) = ButtonTokens.run {
        when (size) {
            ButtonSize.Wrap,
            ButtonSize.Small -> ButtonSmallPadding
            ButtonSize.Medium -> ButtonMediumPadding
            ButtonSize.Large,
            ButtonSize.Fill -> ButtonLargePadding
        }
    }

    @Composable
    fun buttonTextStyle(size: ButtonSize) = TextStyles.titleMedium.run {
        when (size) {
            ButtonSize.Wrap,
            ButtonSize.Small -> copy(fontSize = fontSize - 2)
            else -> this
        }
    }

    @Composable
    fun buttonWidth(size: ButtonSize): Dp =
        LocalConfiguration.current
            .screenWidthDp
            .takeUnless { width -> width == Configuration.SCREEN_WIDTH_DP_UNDEFINED }
            ?.let { total ->
                when (size) {
                    ButtonSize.Wrap -> ButtonTokens.ButtonWrapWidthDivisor.dp
                    ButtonSize.Small -> (total / ButtonTokens.ButtonSmallWidthDivisor).dp
                    ButtonSize.Medium -> (total / ButtonTokens.ButtonMediumWidthDivisor).dp
                    ButtonSize.Large -> (total / ButtonTokens.ButtonLargeWidthDivisor).dp
                    ButtonSize.Fill -> ButtonTokens.ButtonFillWidthDivisor
                }
            } ?: Dp.Unspecified
}

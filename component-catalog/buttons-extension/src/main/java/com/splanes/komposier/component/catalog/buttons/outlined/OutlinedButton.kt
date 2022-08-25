package com.splanes.komposier.component.catalog.buttons.outlined

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.ButtonElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import com.splanes.komposier.component.catalog.buttons.ButtonContentText
import com.splanes.komposier.component.catalog.buttons.ButtonDefaults
import com.splanes.komposier.component.catalog.buttons.ButtonEndSpacer
import com.splanes.komposier.component.catalog.buttons.ButtonIcon
import com.splanes.komposier.component.catalog.buttons.ButtonStartSpacer
import com.splanes.komposier.component.catalog.buttons.outlined.ui.OutlinedButtonUi
import com.splanes.komposier.component.catalog.buttons.ui.ButtonColors
import com.splanes.komposier.component.catalog.buttons.ui.ButtonIcon
import androidx.compose.material3.OutlinedButton as MaterialOutlinedButton

@Composable
fun OutlinedButton(
    buttonUi: OutlinedButtonUi,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    colors: ButtonColors = ButtonDefaults.OutlinedButtonColors,
    elevation: ButtonElevation = ButtonDefaults.OutlinedButtonElevation,
    shape: Shape = ButtonDefaults.OutlinedButtonShape
) {
    MaterialOutlinedButton(
        modifier = modifier
            .heightIn(min = ButtonDefaults.buttonHeight(buttonUi.size))
            .wrapContentWidth()
            .padding(ButtonDefaults.buttonPadding(buttonUi.size)),
        onClick = onClick,
        enabled = buttonUi.enabled,
        elevation = elevation,
        shape = shape,
        colors = colors,
        contentPadding = buttonUi.paddings
    ) {
        with(buttonUi) {
            when {
                buttonIcon != null && buttonIcon.position == ButtonIcon.RelativePosition.Leading -> {
                    ButtonIcon(
                        buttonIcon = buttonIcon,
                        colors = colors,
                        enabled = enabled,
                        description = text
                    )
                    ButtonContentText(
                        text = text,
                        capitalization = capitalization,
                        size = size,
                        colors = colors,
                        enabled = enabled
                    )
                    ButtonEndSpacer(padding = buttonIcon.horizontalPadding, offset = buttonIcon.size)
                }
                buttonIcon != null && buttonIcon.position == ButtonIcon.RelativePosition.Trailing -> {
                    ButtonStartSpacer(padding = buttonIcon.horizontalPadding, offset = buttonIcon.size)
                    ButtonContentText(
                        text = text,
                        capitalization = capitalization,
                        size = size,
                        colors = colors,
                        enabled = enabled
                    )
                    ButtonIcon(buttonIcon, colors, enabled, description = text)
                }
                else -> ButtonContentText(
                    text = text,
                    capitalization = capitalization,
                    size = size,
                    colors = colors,
                    enabled = enabled
                )
            }
        }
    }
}

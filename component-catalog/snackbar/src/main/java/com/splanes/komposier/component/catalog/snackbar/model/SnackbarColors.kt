package com.splanes.komposier.component.catalog.snackbar.model

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.contracts.resources.ColorToken
import com.splanes.komposier.contracts.resources.of

interface SnackbarColors {

    val contentColor: Color
    val containerColor: Color
    val leadingIconColor: Color
    val trailingIconColor: Color
    val trailingActionColor: Color

    interface ColorTokens {
        val content: ColorToken
        val container: ColorToken
        val leadingIcon: ColorToken
        val trailingIcon: ColorToken
        val trailingAction: ColorToken

        @Composable
        fun contentColor(): Color = content.color
        @Composable
        fun containerColor(): Color = container.color
        @Composable
        fun leadingIconColor(): Color = leadingIcon.color
        @Composable
        fun trailingIconColor(): Color = trailingIcon.color
        @Composable
        fun trailingActionColor(): Color = trailingAction.color

        @Composable
        fun toSnackbarColors() = object : SnackbarColors {
            override val contentColor: Color = contentColor()
            override val containerColor: Color = containerColor()
            override val leadingIconColor: Color = leadingIconColor()
            override val trailingIconColor: Color = trailingIconColor()
            override val trailingActionColor: Color = trailingActionColor()

        }
    }

    object Default : ColorTokens {
        override val content: ColorToken = ColorToken.of { onTertiaryContainer }
        override val container: ColorToken = ColorToken.of { tertiaryContainer }
        override val leadingIcon: ColorToken = ColorToken.of { tertiary}
        override val trailingIcon: ColorToken = ColorToken.of { tertiary }
        override val trailingAction: ColorToken = ColorToken.of { onTertiaryContainer }
    }
    object Success : ColorTokens {
        override val content: ColorToken = ColorToken.of { onSuccessContainer }
        override val container: ColorToken = ColorToken.of { successContainer }
        override val leadingIcon: ColorToken = ColorToken.of { success }
        override val trailingIcon: ColorToken = ColorToken.of { success }
        override val trailingAction: ColorToken = ColorToken.of { onSuccessContainer }
    }
    object Warning : ColorTokens {
        override val content: ColorToken = ColorToken.of { onWarningContainer }
        override val container: ColorToken = ColorToken.of { warningContainer }
        override val leadingIcon: ColorToken = ColorToken.of { warning }
        override val trailingIcon: ColorToken = ColorToken.of { warning }
        override val trailingAction: ColorToken = ColorToken.of { onWarningContainer }
    }
    object Info : ColorTokens {
        override val content: ColorToken = ColorToken.of { onInfoContainer }
        override val container: ColorToken = ColorToken.of { infoContainer }
        override val leadingIcon: ColorToken = ColorToken.of { info }
        override val trailingIcon: ColorToken = ColorToken.of { info }
        override val trailingAction: ColorToken = ColorToken.of { onInfoContainer }
    }

    companion object
}
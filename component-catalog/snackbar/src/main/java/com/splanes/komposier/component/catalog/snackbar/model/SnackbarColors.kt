package com.splanes.komposier.component.catalog.snackbar.model

import com.splanes.komposier.component.catalog.snackbar.tokens.SnackbarTokens
import com.splanes.komposier.uitheme.theme.tokens.ColorSchemeTokens

sealed interface SnackbarColors {

    val container: ColorSchemeTokens
    val content: ColorSchemeTokens
    val icon: ColorSchemeTokens

    object Default : SnackbarColors {
        override val container: ColorSchemeTokens = SnackbarTokens.ContentColorDefault
        override val content: ColorSchemeTokens = SnackbarTokens.ContainerColorDefault
        override val icon: ColorSchemeTokens = SnackbarTokens.IconColorDefault
    }

    object Success : SnackbarColors {
        override val container: ColorSchemeTokens = SnackbarTokens.ContentColorSuccess
        override val content: ColorSchemeTokens = SnackbarTokens.ContainerColorSuccess
        override val icon: ColorSchemeTokens = SnackbarTokens.IconColorSuccess
    }

    object Warning : SnackbarColors {
        override val container: ColorSchemeTokens = SnackbarTokens.ContentColorWarning
        override val content: ColorSchemeTokens = SnackbarTokens.ContainerColorWarning
        override val icon: ColorSchemeTokens = SnackbarTokens.IconColorWarning
    }

    object Info : SnackbarColors {
        override val container: ColorSchemeTokens = SnackbarTokens.ContentColorInfo
        override val content: ColorSchemeTokens = SnackbarTokens.ContainerColorInfo
        override val icon: ColorSchemeTokens = SnackbarTokens.IconColorInfo
    }

    data class Custom internal constructor(
        override val container: ColorSchemeTokens,
        override val content: ColorSchemeTokens,
        override val icon: ColorSchemeTokens
    ) : SnackbarColors

    companion object
}

fun SnackbarColors.Companion.colorsDefault() = SnackbarColors.Default
fun SnackbarColors.Companion.colorsSuccess() = SnackbarColors.Success
fun SnackbarColors.Companion.colorsWarning() = SnackbarColors.Warning
fun SnackbarColors.Companion.colorsInfo() = SnackbarColors.Info
fun SnackbarColors.Companion.colorsOf(
    container: ColorSchemeTokens,
    content: ColorSchemeTokens,
    icon: ColorSchemeTokens
) = SnackbarColors.Custom(container = container, content = content, icon = icon)

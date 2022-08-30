package com.splanes.komposier.ui.theme.models.colors

import androidx.annotation.VisibleForTesting
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.commons.errors.BaseException
import com.splanes.komposier.ui.theme.tokens.ColorSchemeTokens
import com.splanes.komposier.ui.theme.tokens.toColor
import kotlin.reflect.KProperty

sealed interface ColorOrToken {
    val color: Color?
    val token: ColorSchemeTokens?

    @Composable
    operator fun getValue(nothing: Any?, property: KProperty<*>?): Color = get()

    @Composable
    fun get(): Color = color ?: token?.toColor() ?: GetValueFromColorOrTokenException().`throw`()

    private class Impl(
        override val color: Color? = null,
        override val token: ColorSchemeTokens? = null
    ) : ColorOrToken

    @VisibleForTesting(otherwise = VisibleForTesting.PRIVATE)
    class GetValueFromColorOrTokenException : BaseException() {
        override val message: String =
            "Impossible to resolve this ColorOrToken object. Both (color & token) are null. " +
                "Ensure to set at least one of them."
    }

    companion object {
        fun of(color: Color? = null, token: ColorSchemeTokens? = null): ColorOrToken =
            Impl(color, token)
    }
}

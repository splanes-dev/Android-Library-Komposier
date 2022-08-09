package com.splanes.komposier.contracts.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.splanes.komposier.contracts.theme.Colors
import com.splanes.komposier.contracts.theme.colors.ThemeColorScheme
import kotlin.random.Random

interface ColorToken {
    val token: Int

    val color: Color
        @Composable get

    companion object
}

fun ColorToken.Companion.of(
    token: Int = Random(System.currentTimeMillis()).nextInt(),
    color: @Composable ThemeColorScheme.() -> Color
) = object : ColorToken {
    override val token: Int
        get() = token

    override val color: Color
        @Composable get() = color(Colors)

}
package com.splanes.komposier.uitheme.theme.defaults.colors

import com.splanes.komposier.uitheme.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.uitheme.theme.models.colors.ThemeColors
import kotlin.random.Random

interface DefaultThemeColors {
    val baseColors: List<ThemeBaseColor>
    val light: ThemeColorScheme
    val dark: ThemeColorScheme
    fun colors(): ThemeColors = ThemeColors(light, dark)

    companion object
}

fun DefaultThemeColors.Companion.all(): List<DefaultThemeColors> =
    listOf(
        ButterflyBushThemeColors,
        MediumCarmineThemeColors,
        OrientThemeColors,
        AmberThemeColors
    )

fun DefaultThemeColors.Companion.randomBaseColor(baseColor: ThemeBaseColor): DefaultThemeColors =
    DefaultThemeColors
        .all()
        .filter { themeColors -> themeColors.baseColors.contains(baseColor) }
        .let { list ->
            val index = Random.nextInt(from = 0, until = list.count())
            list[index]
        }

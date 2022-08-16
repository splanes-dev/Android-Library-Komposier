package com.splanes.komposier.uitheme.theme.models.typographies

import androidx.annotation.FontRes
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

data class FontParams(
    @FontRes val id: Int,
    val weight: FontWeight = FontWeight.Normal,
    val style: FontStyle = FontStyle.Normal
)

fun FontParams.toFont() = Font(
    resId = id,
    weight = weight,
    style = style,
    loadingStrategy = FontLoadingStrategy.OptionalLocal
)
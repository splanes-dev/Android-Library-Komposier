package com.splanes.komposier.uitheme.theme.models.typographies

import androidx.compose.ui.text.font.FontWeight

data class TextStyleParams(
    val fontWeight: FontWeight = FontWeight.Normal,
    val fontSize: Int,
    val lineHeight: Int,
    val letterSpacing: Double
)

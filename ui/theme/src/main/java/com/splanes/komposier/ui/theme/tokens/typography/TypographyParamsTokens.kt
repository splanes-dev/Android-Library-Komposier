package com.splanes.komposier.ui.theme.tokens.typography

import androidx.compose.ui.text.font.FontWeight
import com.splanes.komposier.ui.theme.models.typographies.TextStyleParams

object TypographyParamsTokens {
    val BodyLarge: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.5,
            lineHeight = 24,
            fontSize = 16
        )
    }
    val BodyMedium: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.25,
            lineHeight = 20,
            fontSize = 14
        )
    }
    val BodySmall: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.4000000059604645,
            lineHeight = 16,
            fontSize = 12
        )
    }
    val DisplayLarge: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = -0.25,
            lineHeight = 64,
            fontSize = 57
        )
    }
    val DisplayMedium: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = .0,
            lineHeight = 52,
            fontSize = 45
        )
    }
    val DisplaySmall: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = .0,
            lineHeight = 44,
            fontSize = 36
        )
    }
    val HeadlineLarge: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = .0,
            lineHeight = 40,
            fontSize = 32
        )
    }
    val HeadlineMedium: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = .0,
            lineHeight = 36,
            fontSize = 28
        )
    }
    val HeadlineSmall: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = .0,
            lineHeight = 32,
            fontSize = 24
        )
    }
    val LabelLarge: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.10000000149011612,
            lineHeight = 20,
            fontSize = 14
        )
    }
    val LabelMedium: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.5,
            lineHeight = 16,
            fontSize = 12
        )
    }
    val LabelSmall: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.25,
            lineHeight = 20,
            fontSize = 14
        )
    }
    val TitleLarge: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.W400,
            letterSpacing = 0.0,
            lineHeight = 28,
            fontSize = 22
        )
    }
    val TitleMedium: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.15000000596046448,
            lineHeight = 24,
            fontSize = 16
        )
    }
    val TitleSmall: TextStyleParams by lazy {
        TextStyleParams(
            fontWeight = FontWeight.Medium,
            letterSpacing = 0.10000000149011612,
            lineHeight = 20,
            fontSize = 14
        )
    }
}

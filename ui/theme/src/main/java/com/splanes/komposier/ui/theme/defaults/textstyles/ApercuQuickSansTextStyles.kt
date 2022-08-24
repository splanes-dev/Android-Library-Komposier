package com.splanes.komposier.ui.theme.defaults.textstyles

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.splanes.komposier.ui.theme.models.typographies.ThemeTextStyles
import com.splanes.komposier.ui.theme.tokens.typography.TypographyFontFamilyTokens
import com.splanes.komposier.ui.theme.tokens.typography.TypographyParamsTokens

object ApercuQuickSansTextStyles : ThemeTextStyles {
    override val displayLarge: TextStyle = with(TypographyParamsTokens.DisplayLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displayMedium: TextStyle = with(TypographyParamsTokens.DisplayMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displaySmall: TextStyle = with(TypographyParamsTokens.DisplaySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineLarge: TextStyle = with(TypographyParamsTokens.HeadlineLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineMedium: TextStyle = with(TypographyParamsTokens.HeadlineMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineSmall: TextStyle = with(TypographyParamsTokens.HeadlineSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleLarge: TextStyle = with(TypographyParamsTokens.TitleLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleMedium: TextStyle = with(TypographyParamsTokens.TitleMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.BentonSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleSmall: TextStyle = with(TypographyParamsTokens.TitleSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.BentonSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyLarge: TextStyle = with(TypographyParamsTokens.BodyLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.BentonSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyMedium: TextStyle = with(TypographyParamsTokens.BodyMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.BentonSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodySmall: TextStyle = with(TypographyParamsTokens.BodySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.BentonSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelLarge: TextStyle = with(TypographyParamsTokens.LabelLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelMedium: TextStyle = with(TypographyParamsTokens.LabelMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelSmall: TextStyle = with(TypographyParamsTokens.LabelSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Quicksand,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
}

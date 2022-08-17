package com.splanes.komposier.uitheme.theme.defaults.textstyles

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles
import com.splanes.komposier.uitheme.theme.tokens.typography.TypographyFontFamilyTokens
import com.splanes.komposier.uitheme.theme.tokens.typography.TypographyParamsTokens

internal object LatoApercuTextStyles : ThemeTextStyles {
    override val displayLarge: TextStyle = with(TypographyParamsTokens.DisplayLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displayMedium: TextStyle = with(TypographyParamsTokens.DisplayMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displaySmall: TextStyle = with(TypographyParamsTokens.DisplaySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineLarge: TextStyle = with(TypographyParamsTokens.HeadlineLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineMedium: TextStyle = with(TypographyParamsTokens.HeadlineMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineSmall: TextStyle = with(TypographyParamsTokens.HeadlineSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleLarge: TextStyle = with(TypographyParamsTokens.TitleLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleMedium: TextStyle = with(TypographyParamsTokens.TitleMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleSmall: TextStyle = with(TypographyParamsTokens.TitleSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyLarge: TextStyle = with(TypographyParamsTokens.BodyLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyMedium: TextStyle = with(TypographyParamsTokens.BodyMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodySmall: TextStyle = with(TypographyParamsTokens.BodySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelLarge: TextStyle = with(TypographyParamsTokens.LabelLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelMedium: TextStyle = with(TypographyParamsTokens.LabelMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.Lato,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelSmall: TextStyle = with(TypographyParamsTokens.LabelSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.ApercuPro,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
}

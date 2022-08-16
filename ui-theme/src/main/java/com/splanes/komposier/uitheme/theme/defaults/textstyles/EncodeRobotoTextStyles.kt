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

internal object EncodeRobotoTextStyles : ThemeTextStyles {
    override val displayLarge: TextStyle = with(TypographyParamsTokens.DisplayLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = FontWeight.Light,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displayMedium: TextStyle = with(TypographyParamsTokens.DisplayMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val displaySmall: TextStyle = with(TypographyParamsTokens.DisplaySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineLarge: TextStyle = with(TypographyParamsTokens.HeadlineLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineMedium: TextStyle = with(TypographyParamsTokens.HeadlineMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val headlineSmall: TextStyle = with(TypographyParamsTokens.HeadlineSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleLarge: TextStyle = with(TypographyParamsTokens.TitleLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleMedium: TextStyle = with(TypographyParamsTokens.TitleMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val titleSmall: TextStyle = with(TypographyParamsTokens.TitleSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyLarge: TextStyle = with(TypographyParamsTokens.BodyLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodyMedium: TextStyle = with(TypographyParamsTokens.BodyMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val bodySmall: TextStyle = with(TypographyParamsTokens.BodySmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelLarge: TextStyle = with(TypographyParamsTokens.LabelLarge) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelMedium: TextStyle = with(TypographyParamsTokens.LabelMedium) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.EncodeSansCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
    override val labelSmall: TextStyle = with(TypographyParamsTokens.LabelSmall) {
        TextStyle(
            fontFamily = TypographyFontFamilyTokens.RobotoCondensed,
            fontWeight = fontWeight,
            letterSpacing = letterSpacing.sp,
            lineHeight = lineHeight.sp,
            fontSize = fontSize.sp
        )
    }
}

@Composable
@Preview(
    name = "EncodeSans - Roboto",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF
)
private fun EncodeRobotoTextStylesPreview() {
    with(EncodeRobotoTextStyles) {
        Column {
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "DisplayLarge",
                style = displayLarge
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "DisplayMedium",
                style = displayMedium
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "DisplaySmall",
                style = displaySmall
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "HeadlineLarge",
                style = headlineLarge
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "HeadlineMedium",
                style = headlineMedium
            )
            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "HeadlineSmall",
                style = headlineSmall
            )
            Text(modifier = Modifier.padding(top = 8.dp), text = "TitleLarge", style = titleLarge)
            Text(modifier = Modifier.padding(top = 8.dp), text = "TitleMedium", style = titleMedium)
            Text(modifier = Modifier.padding(top = 8.dp), text = "TitleSmall", style = titleSmall)
            Text(modifier = Modifier.padding(top = 8.dp), text = "BodyLarge", style = bodyLarge)
            Text(modifier = Modifier.padding(top = 8.dp), text = "BodyMedium", style = bodyMedium)
            Text(modifier = Modifier.padding(top = 8.dp), text = "BodySmall", style = bodySmall)
            Text(modifier = Modifier.padding(top = 8.dp), text = "LabelLarge", style = labelLarge)
            Text(modifier = Modifier.padding(top = 8.dp), text = "LabelMedium", style = labelMedium)
            Text(modifier = Modifier.padding(top = 8.dp), text = "LabelSmall", style = labelSmall)
        }
    }
}
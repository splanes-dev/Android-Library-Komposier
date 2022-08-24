package com.splanes.komposier.ui.theme.tokens.typography

import androidx.compose.runtime.Composable
import com.splanes.komposier.ui.theme.TextStyles

enum class TypographyTokens {
    BodyLarge,
    BodyMedium,
    BodySmall,
    DisplayLarge,
    DisplayMedium,
    DisplaySmall,
    HeadlineLarge,
    HeadlineMedium,
    HeadlineSmall,
    LabelLarge,
    LabelMedium,
    LabelSmall,
    TitleLarge,
    TitleMedium,
    TitleSmall,
}

@Composable
fun TypographyTokens.textStyle() =
    when (this) {
        TypographyTokens.BodyLarge -> TextStyles.bodyLarge
        TypographyTokens.BodyMedium -> TextStyles.bodyMedium
        TypographyTokens.BodySmall -> TextStyles.bodySmall
        TypographyTokens.DisplayLarge -> TextStyles.displayLarge
        TypographyTokens.DisplayMedium -> TextStyles.displayMedium
        TypographyTokens.DisplaySmall -> TextStyles.displaySmall
        TypographyTokens.HeadlineLarge -> TextStyles.headlineLarge
        TypographyTokens.HeadlineMedium -> TextStyles.headlineMedium
        TypographyTokens.HeadlineSmall -> TextStyles.headlineSmall
        TypographyTokens.LabelLarge -> TextStyles.labelLarge
        TypographyTokens.LabelMedium -> TextStyles.labelMedium
        TypographyTokens.LabelSmall -> TextStyles.labelSmall
        TypographyTokens.TitleLarge -> TextStyles.titleLarge
        TypographyTokens.TitleMedium -> TextStyles.titleMedium
        TypographyTokens.TitleSmall -> TextStyles.titleSmall
    }


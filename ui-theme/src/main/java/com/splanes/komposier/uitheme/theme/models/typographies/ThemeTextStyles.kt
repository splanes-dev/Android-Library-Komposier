package com.splanes.komposier.uitheme.theme.models.typographies

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle

interface ThemeTextStyles {
    val displayLarge: TextStyle
    val displayMedium: TextStyle
    val displaySmall: TextStyle
    val headlineLarge: TextStyle
    val headlineMedium: TextStyle
    val headlineSmall: TextStyle
    val titleLarge: TextStyle
    val titleMedium: TextStyle
    val titleSmall: TextStyle
    val bodyLarge: TextStyle
    val bodyMedium: TextStyle
    val bodySmall: TextStyle
    val labelLarge: TextStyle
    val labelMedium: TextStyle
    val labelSmall: TextStyle
}

fun ThemeTextStyles.toMaterialTypo() = Typography(
    displayLarge = displayLarge,
    displayMedium = displayMedium,
    displaySmall = displaySmall,
    headlineLarge = headlineLarge,
    headlineMedium = headlineMedium,
    headlineSmall = headlineSmall,
    titleLarge = titleLarge,
    titleMedium = titleMedium,
    titleSmall = titleSmall,
    bodyLarge = bodyLarge,
    bodyMedium = bodyMedium,
    bodySmall = bodySmall,
    labelLarge = labelLarge,
    labelMedium = labelMedium,
    labelSmall = labelSmall,
)
package com.splanes.komposier.uitheme.theme.defaults.textstyles

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.splanes.komposier.uitheme.theme.AppTheme
import com.splanes.komposier.uitheme.theme.Colors
import com.splanes.komposier.uitheme.theme.Paddings
import com.splanes.komposier.uitheme.theme.Shapes
import com.splanes.komposier.uitheme.theme.TextStyles
import com.splanes.komposier.uitheme.theme.defaults.DefaultColors
import com.splanes.komposier.uitheme.theme.defaults.DefaultShapes
import com.splanes.komposier.uitheme.theme.defaults.DefaultTextStyles
import com.splanes.komposier.uitheme.theme.defaults.ThemeDefaults
import com.splanes.komposier.uitheme.theme.models.typographies.ThemeTextStyles


internal fun ThemeTextStyles.styles() = listOf(
    "DisplayLarge" to displayLarge,
    "DisplayMedium" to displayMedium,
    "DisplaySmall" to displaySmall,
    "HeadlineLarge" to headlineLarge,
    "HeadlineMedium" to headlineMedium,
    "HeadlineSmall" to headlineSmall,
    "TitleLarge" to titleLarge,
    "TitleMedium" to titleMedium,
    "TitleSmall" to titleSmall,
    "BodyLarge" to bodyLarge,
    "BodyMedium" to bodyMedium,
    "BodySmall" to bodySmall,
    "LabelLarge" to labelLarge,
    "LabelMedium" to labelMedium,
    "LabelSmall" to labelSmall,
)

@Composable
private fun TextStyleColumn() {
    Column(
        modifier = Modifier
            .padding(
                vertical = Paddings.medium,
                horizontal = Paddings.mediumSmall,
            )
            .background(
                color = Colors.surface,
                shape = Shapes.medium
            ),
        verticalArrangement = Arrangement.Center
    ) {
        TextStyles.styles().forEach { (name, style) ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp, horizontal = Paddings.medium)
            ) {
                Text(text = name, style = style, color = Colors.onSurface)
            }
        }
    }
}

@Composable
@Preview(
    name = "Lato & Apercu Dark", group = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun LatoApercuTextStylesDarkPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Red,
        DefaultTextStyles.LatoApercu,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}

@Composable
@Preview(
    name = "Lato & Apercu", group = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
private fun LatoApercuTextStylesPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Red,
        DefaultTextStyles.LatoApercu,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}

@Composable
@Preview(
    name = "EncodeSans & Roboto Dark", group = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun EncodeRobotoTextStylesDarkPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Red,
        DefaultTextStyles.EncodeRoboto,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}

@Composable
@Preview(
    name = "EncodeSans & Roboto", group = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
private fun EncodeRobotoTextStylesPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Red,
        DefaultTextStyles.EncodeRoboto,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}

@Composable
@Preview(
    name = "Apercu & Quicksans Dark", group = "Dark", uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
private fun ApercuQuickSansTextStylesDarkPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Blue,
        DefaultTextStyles.ApercuQuicksans,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}

@Composable
@Preview(
    name = "Apercu & Quicksans", group = "Light", uiMode = Configuration.UI_MODE_NIGHT_NO or Configuration.UI_MODE_TYPE_NORMAL
)
private fun ApercuQuickSansTextStylesPreview() {
    AppTheme.withProviderOf(
        DefaultColors.Blue,
        DefaultTextStyles.ApercuQuicksans,
        DefaultShapes.Rounded,
    )
    AppTheme.Theme { TextStyleColumn() }
}
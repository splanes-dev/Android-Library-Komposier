package com.splanes.komposier.ui.theme

import androidx.compose.runtime.Composable
import com.splanes.komposier.ui.theme.defaults.DefaultColors
import com.splanes.komposier.ui.theme.defaults.DefaultShapes
import com.splanes.komposier.ui.theme.defaults.DefaultTextStyles
import com.splanes.komposier.ui.theme.models.SystemUiMode
import com.splanes.komposier.ui.theme.models.Theme
import com.splanes.komposier.ui.theme.providers.ThemeProvider
import com.splanes.komposier.ui.theme.providers.fromDefaults

object AppTheme {

    private val ProviderFallback by lazy {
        ThemeProvider.fromDefaults(
            colors = DefaultColors.MediumCarmine,
            textStyles = DefaultTextStyles.EncodeRoboto,
            shapes = DefaultShapes.Rounded
        )
    }
    private var themeProvider: ThemeProvider<Theme>? = null

    val provider: ThemeProvider<Theme>
        get() = themeProvider ?: ProviderFallback

    fun withProvider(provider: ThemeProvider<Theme>) {
        themeProvider = provider
    }

    fun withProviderOf(
        colors: DefaultColors,
        textStyles: DefaultTextStyles,
        shapes: DefaultShapes
    ) {
        themeProvider = ThemeProvider.fromDefaults(colors, textStyles, shapes)
    }

    @Composable
    fun Theme(
        theme: Theme = provider.localTheme,
        themeUiMode: Theme.UiMode = Theme.SystemUiMode,
        content: @Composable () -> Unit
    ) {
        provider.ThemeComposition(theme, themeUiMode, content)
    }
}

@Composable
fun Theme(
    themeUiMode: Theme.UiMode = Theme.UiMode.System,
    content: @Composable () -> Unit
) {
    AppTheme.Theme(themeUiMode = themeUiMode, content = content)
}

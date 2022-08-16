package com.splanes.komposier.uitheme.theme

import androidx.compose.runtime.Composable
import com.splanes.komposier.uitheme.theme.defaults.DefaultColors
import com.splanes.komposier.uitheme.theme.defaults.DefaultShapes
import com.splanes.komposier.uitheme.theme.defaults.DefaultTextStyles
import com.splanes.komposier.uitheme.theme.models.Theme
import com.splanes.komposier.uitheme.theme.providers.ThemeProvider
import com.splanes.komposier.uitheme.theme.providers.fromDefaults


object AppTheme {

    lateinit var provider: ThemeProvider<Theme>

    fun useDefaultProvider(
        colors: DefaultColors,
        textStyles: DefaultTextStyles,
        shapes: DefaultShapes
    ) {
        provider = ThemeProvider.fromDefaults(colors, textStyles, shapes)
    }

    @Composable
    fun Theme(
        theme: Theme = safeProvider().currentLocalTheme(),
        content: @Composable () -> Unit
    ) {
        provider.ThemeComposition(theme, content)
    }

    fun safeProvider(): ThemeProvider<Theme> {
        if (!::provider.isInitialized) {
            useDefaultProvider(
                DefaultColors.Red,
                DefaultTextStyles.EncodeRoboto,
                DefaultShapes.Rounded
            )
        }
        return provider
    }
}
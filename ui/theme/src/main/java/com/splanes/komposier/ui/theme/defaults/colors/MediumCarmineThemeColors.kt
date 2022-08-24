package com.splanes.komposier.ui.theme.defaults.colors

import androidx.compose.ui.graphics.Color
import com.splanes.komposier.ui.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.ui.theme.models.colors.of

internal object MediumCarmineThemeColors : DefaultThemeColors {
    override val baseColors: List<ThemeBaseColor> = listOf(ThemeBaseColor.Red)
    override val light by lazy {
        ThemeColorScheme.of(
            primary = Color(0xFFA33C2D),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFFFDAD4),
            onPrimaryContainer = Color(0xFF400100),
            inversePrimary = Color(0xFFFFB4A7),
            secondary = Color(0xFF9C413C),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFFFDAD6),
            onSecondaryContainer = Color(0xFF410003),
            tertiary = Color(0xFF904D00),
            onTertiary = Color(0xFFFFFFFF),
            tertiaryContainer = Color(0xFFFFDCC2),
            onTertiaryContainer = Color(0xFF2E1500),
            background = Color(0xFFFFFBFF),
            onBackground = Color(0xFF201A19),
            surface = Color(0xFFFFFBFF),
            onSurface = Color(0xFF201A19),
            surfaceVariant = Color(0xFFF5DDD9),
            onSurfaceVariant = Color(0xFF534341),
            surfaceTint = Color(0xFFA33C2D),
            inverseSurface = Color(0xFF362F2D),
            inverseOnSurface = Color(0xFFFBEEEB),
            error = Color(0xFFBA1A1A),
            onError = Color(0xFFFFDAD6),
            errorContainer = Color(0xFFFFFFFF),
            onErrorContainer = Color(0xFF410002),
            outline = Color(0xFF857370),
            outlineVariant = Color(0xFF857370),
            scrim = Color(0xFF000000),
            success = Color(0xFF90C867),
            successContainer = Color(0xFFB8F38C),
            onSuccessContainer = Color(0xFF0B2000),
            warning = Color(0xFFFF8844),
            warningContainer = Color(0xFFFFDBCB),
            onWarningContainer = Color(0xFF341100),
            info = Color(0xFF494FB9),
            infoContainer = Color(0xFFE0E0FF),
            onInfoContainer = Color(0xFF02006E)
        )
    }
    override val dark by lazy {
        ThemeColorScheme.of(
            primary = Color(0xFFFFB4A7),
            onPrimary = Color(0xFF630E05),
            primaryContainer = Color(0xFF832519),
            onPrimaryContainer = Color(0xFFFFDAD4),
            inversePrimary = Color(0xFFA33C2D),
            secondary = Color(0xFFFFB3AD),
            onSecondary = Color(0xFF5F1413),
            secondaryContainer = Color(0xFF7E2A27),
            onSecondaryContainer = Color(0xFFFFDAD6),
            tertiary = Color(0xFFFFB77B),
            onTertiary = Color(0xFF4D2700),
            tertiaryContainer = Color(0xFF6D3900),
            onTertiaryContainer = Color(0xFFFFDCC2),
            background = Color(0xFF201A19),
            onBackground = Color(0xFFEDE0DD),
            surface = Color(0xFF201A19),
            onSurface = Color(0xFFEDE0DD),
            surfaceVariant = Color(0xFF534341),
            onSurfaceVariant = Color(0xFFD8C2BE),
            surfaceTint = Color(0xFFFFB4A7),
            inverseSurface = Color(0xFFEDE0DD),
            inverseOnSurface = Color(0xFF201A19),
            error = Color(0xFFFFB4AB),
            onError = Color(0xFF690005),
            errorContainer = Color(0xFF93000A),
            onErrorContainer = Color(0xFFFFDAD6),
            outline = Color(0xFFA08C89),
            outlineVariant = Color(0xFFA08C89),
            scrim = Color(0xFF000000),
            success = Color(0xFF9DD673),
            successContainer = Color(0xFF245100),
            onSuccessContainer = Color(0xFFB8F38C),
            warning = Color(0xFFFFB691),
            warningContainer = Color(0xFF783100),
            onWarningContainer = Color(0xFFFFDBCB),
            info = Color(0xFFBFC2FF),
            infoContainer = Color(0xFF3339A3),
            onInfoContainer = Color(0xFFE0E0FF)
        )
    }
}

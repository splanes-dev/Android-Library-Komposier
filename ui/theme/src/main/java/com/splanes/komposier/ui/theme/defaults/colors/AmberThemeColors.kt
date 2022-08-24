package com.splanes.komposier.ui.theme.defaults.colors

import androidx.compose.ui.graphics.Color
import com.splanes.komposier.ui.theme.models.colors.ThemeColorScheme
import com.splanes.komposier.ui.theme.models.colors.of

object AmberThemeColors : DefaultThemeColors {
    override val baseColors: List<ThemeBaseColor> = listOf(ThemeBaseColor.Amber)
    override val light by lazy {
        ThemeColorScheme.of(
            primary = Color(0xFF944A00),
            onPrimary = Color(0xFFFFFFFF),
            primaryContainer = Color(0xFFFFDCC5),
            onPrimaryContainer = Color(0xFF301400),
            secondary = Color(0xFF9D4044),
            onSecondary = Color(0xFFFFFFFF),
            secondaryContainer = Color(0xFFFFDAD9),
            onSecondaryContainer = Color(0xFF400009),
            tertiary = Color(0xFF775A00),
            onTertiary = Color(0xFFFFFFFF),
            tertiaryContainer = Color(0xFFFFDF99),
            onTertiaryContainer = Color(0xFF251A00),
            error = Color(0xFFBA1A1A),
            errorContainer = Color(0xFFFFDAD6),
            onError = Color(0xFFFFFFFF),
            onErrorContainer = Color(0xFF410002),
            background = Color(0xFFFFFBFF),
            onBackground = Color(0xFF201A17),
            surface = Color(0xFFFFFBFF),
            onSurface = Color(0xFF201A17),
            surfaceVariant = Color(0xFFF3DFD2),
            onSurfaceVariant = Color(0xFF52443B),
            outline = Color(0xFF84746A),
            inverseOnSurface = Color(0xFFFBEEE8),
            inverseSurface = Color(0xFF362F2B),
            inversePrimary = Color(0xFFFFB783),
            surfaceTint = Color(0xFF944A00),
            outlineVariant = Color(0xFF84746A),
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
            primary = Color(0xFFFFB783),
            onPrimary = Color(0xFF4F2500),
            primaryContainer = Color(0xFF713700),
            onPrimaryContainer = Color(0xFFFFDCC5),
            secondary = Color(0xFFFFB3B3),
            onSecondary = Color(0xFF60111A),
            secondaryContainer = Color(0xFF7F292E),
            onSecondaryContainer = Color(0xFFFFDAD9),
            tertiary = Color(0xFFF1C040),
            onTertiary = Color(0xFF3F2E00),
            tertiaryContainer = Color(0xFF5A4300),
            onTertiaryContainer = Color(0xFFFFDF99),
            error = Color(0xFFFFB4AB),
            errorContainer = Color(0xFF93000A),
            onError = Color(0xFF690005),
            onErrorContainer = Color(0xFFFFDAD6),
            background = Color(0xFF201A17),
            onBackground = Color(0xFFECE0DA),
            surface = Color(0xFF201A17),
            onSurface = Color(0xFFECE0DA),
            surfaceVariant = Color(0xFF52443B),
            onSurfaceVariant = Color(0xFFD6C3B7),
            outline = Color(0xFF9F8D83),
            inverseOnSurface = Color(0xFF201A17),
            inverseSurface = Color(0xFFECE0DA),
            inversePrimary = Color(0xFF944A00),
            surfaceTint = Color(0xFFFFB783),
            outlineVariant = Color(0xFF9F8D83),
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

package com.splanes.komposier.uitheme.theme.tokens.typography

import androidx.annotation.FontRes
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontLoadingStrategy
import androidx.compose.ui.text.font.FontWeight
import com.splanes.komposier.uitheme.theme.models.typographies.FontParams
import com.splanes.komposier.uitheme.theme.models.typographies.toFont
import com.splanes.komposier.uitheme.R.font as UiThemeFontsResId

object TypographyFontFamilyTokens {

    val ApercuPro: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.apercu_pro_medium, weight = FontWeight.Bold),
            fontOptionLocalOf(UiThemeFontsResId.apercu_pro_medium, weight = FontWeight.Medium),
            fontOptionLocalOf(UiThemeFontsResId.apercu_pro_regular),
            fontOptionLocalOf(UiThemeFontsResId.apercu_pro_light, weight = FontWeight.Light),
        )
    }

    val BentonSansCondensed: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.benton_sans_condensed_bold, weight = FontWeight.Bold),
            fontOptionLocalOf(UiThemeFontsResId.benton_sans_condensed_medium, weight = FontWeight.Medium),
            fontOptionLocalOf(UiThemeFontsResId.benton_sans_condensed_regular),
            fontOptionLocalOf(UiThemeFontsResId.benton_sans_condensed_regular, weight = FontWeight.Light),
        )
    }

    val EncodeSansCondensed: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.encode_sans_condensed_bold, weight = FontWeight.Bold),
            fontOptionLocalOf(UiThemeFontsResId.encode_sans_condensed_medium, weight = FontWeight.Medium),
            fontOptionLocalOf(UiThemeFontsResId.encode_sans_condensed_regular),
            fontOptionLocalOf(UiThemeFontsResId.encode_sans_condensed_light, weight = FontWeight.Light),
        )
    }

    val Lato: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.lato_bold, weight = FontWeight.Bold),
            fontOptionLocalOf(UiThemeFontsResId.lato_bold, weight = FontWeight.Medium),
            fontOptionLocalOf(UiThemeFontsResId.lato_regular),
            fontOptionLocalOf(UiThemeFontsResId.lato_light, weight = FontWeight.Light),
        )
    }

    val Poppins: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.poppins_semibold, weight = FontWeight.SemiBold),
            fontOptionLocalOf(UiThemeFontsResId.poppins_medium, weight = FontWeight.Medium),
            fontOptionLocalOf(UiThemeFontsResId.poppins_regular),
            fontOptionLocalOf(UiThemeFontsResId.poppins_light, weight = FontWeight.Light),
        )
    }

    val Quicksand: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.quicksand_regular),
            fontOptionLocalOf(UiThemeFontsResId.quicksand_light, weight = FontWeight.Light),
        )
    }

    val RobotoCondensed: FontFamily by lazy {
        FontFamily(
            fontOptionLocalOf(UiThemeFontsResId.roboto_condensed_regular),
            fontOptionLocalOf(UiThemeFontsResId.roboto_condensed_light, weight = FontWeight.Light),
        )
    }

    val MangoSticky: FontFamily by lazy {
        FontFamily(fontOptionLocalOf(UiThemeFontsResId.mango_sticky))
    }

    fun fontFamilyOf(vararg params: FontParams) = FontFamily(
        params.map { param -> param.toFont() }
    )

    private fun fontOptionLocalOf(@FontRes id: Int, weight: FontWeight = FontWeight.Normal) =
        Font(id, weight = weight, loadingStrategy = FontLoadingStrategy.OptionalLocal)
}
package com.splanes.komposier.ui.theme.defaults

enum class DefaultColors {
    MediumCarmine,
    ButterflyBush,
    Orient,
    Amber,
    ;

    companion object {
        fun random() = DefaultColors.values().apply { shuffle() }.first()
    }
}

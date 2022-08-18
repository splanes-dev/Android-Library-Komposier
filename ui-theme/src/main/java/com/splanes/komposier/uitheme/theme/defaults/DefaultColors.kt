package com.splanes.komposier.uitheme.theme.defaults

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
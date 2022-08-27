package com.splanes.komposier.component.catalog.lottie.ui

sealed interface LottieAnimationSpeed {

    val speed: Float

    @JvmInline
    private value class Impl(val value: Float) : LottieAnimationSpeed {
        override val speed: Float
            get() = TODO("Not yet implemented")
    }

    companion object {
        val `0x25`: LottieAnimationSpeed = Impl(value = .25f)
        val `0x50`: LottieAnimationSpeed = Impl(value = .5f)
        val `0x75`: LottieAnimationSpeed = Impl(value = .75f)
        val Normal: LottieAnimationSpeed = Impl(value = 1f)
        val `1x25`: LottieAnimationSpeed = Impl(value = 1.25f)
        val `1x50`: LottieAnimationSpeed = Impl(value = 1.5f)
        val `1x75`: LottieAnimationSpeed = Impl(value = 1.75f)
        val Double: LottieAnimationSpeed = Impl(value = 2f)
    }
}

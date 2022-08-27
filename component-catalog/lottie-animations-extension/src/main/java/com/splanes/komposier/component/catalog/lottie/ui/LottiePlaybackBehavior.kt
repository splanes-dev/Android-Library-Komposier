package com.splanes.komposier.component.catalog.lottie.ui

data class LottiePlaybackBehavior(
    val autoPlay: Boolean,
    val repeat: LottieCompositionIteration
)

sealed interface LottieCompositionIteration {

    val times: Int

    @JvmInline
    value class Multiple(override val times: Int) : LottieCompositionIteration

    companion object {
        val Once = Multiple(times = 1)
        val IterateForever = Multiple(times = Int.MAX_VALUE)
    }
}

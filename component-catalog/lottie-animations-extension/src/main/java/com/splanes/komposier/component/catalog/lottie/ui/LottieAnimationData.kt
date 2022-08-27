package com.splanes.komposier.component.catalog.lottie.ui

import androidx.compose.ui.layout.ContentScale
import com.airbnb.lottie.RenderMode
import com.airbnb.lottie.compose.LottieCompositionSpec

data class LottieAnimationData(
    val compositionSpec: LottieCompositionSpec,
    val playbackBehavior: LottiePlaybackBehavior,
    val renderMode: RenderMode,
    val scale: ContentScale
)

package com.splanes.komposier.component.catalog.lottie

import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieAnimationState
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.splanes.komposier.component.catalog.lottie.ui.LottieAnimationData
import com.splanes.komposier.component.catalog.lottie.ui.LottieCompositionIteration

@Composable
fun animateLottieRawResAsState(): LottieAnimationState {

}

@Composable
fun animateLottieAsState(
    compositionSpec: LottieCompositionSpec,
    iteration: LottieCompositionIteration = LottieCompositionIteration.IterateForever,
    speed: LottieAnimationSpeed = LottieAnimationSpeed.Normal
): LottieAnimationState {

}

@Composable
fun rememberRawResComposition(@RawRes rawRes: Int) =
    rememberLottieComposition(spec = LottieCompositionSpec.RawRes(rawRes))

@Composable
fun LottieAnimationData.rememberComposition() =
    rememberLottieComposition(compositionSpec)

@Composable
fun LottieAnimation(data: LottieAnimationData) {
    val composition by data.rememberComposition()
    val animState = animateLottieCompositionAsState(
        composition = composition,
        iterations = data.playbackBehavior.repeat.times
    )

    animState

    LottieAnimation(
        composition = composition,
        progress = { animState },
        renderMode = data.renderMode,
        contentScale = data.scale
    )
}

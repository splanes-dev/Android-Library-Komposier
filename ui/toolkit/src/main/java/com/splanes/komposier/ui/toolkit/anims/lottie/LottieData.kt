/*
package com.splanes.komposier.ui.toolkit.anims.lottie

import android.net.Uri
import androidx.annotation.FloatRange
import androidx.annotation.RawRes
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieCancellationBehavior
import com.airbnb.lottie.compose.LottieClipSpec
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition

sealed interface LottieData {
    val animSource: LottieCompositionSource
    val restartOnPlay: Boolean
    val clipSpec: LottieClipSpec?
    val playback: LottiePlayback
    val cancellationBehavior: LottieCancellationBehavior
    val ignoreSystemAnimatorScale: Boolean

    companion object
}

@Composable
fun LottieAnimation(data: LottieData) {
    val composition by rememberLottieComposition(spec = data.animSource.compositionSpec)
    val progress by rememberLo(
        composition = composition,
        isPlaying =,
        restartOnPlay = data.,
        clipSpec =,
        speed =,
        iterations =,
        cancellationBehavior =,
        ignoreSystemAnimatorScale =,
    )
}

sealed interface LottieCompositionSource {

    val compositionSpec: LottieCompositionSpec
        get() = when (this) {
            is Asset -> LottieCompositionSpec.Asset(name)
            is File -> LottieCompositionSpec.File(name)
            is Json -> LottieCompositionSpec.JsonString(json)
            is Provider -> LottieCompositionSpec.ContentProvider(contentUri)
            is Raw -> LottieCompositionSpec.RawRes(res)
            is Url -> LottieCompositionSpec.Url(url)
        }

    @JvmInline
    value class Raw(@RawRes val res: Int) : LottieCompositionSource

    @JvmInline
    value class Url(val url: String) : LottieCompositionSource

    @JvmInline
    value class Asset(val name: String) : LottieCompositionSource

    @JvmInline
    value class File(val name: String) : LottieCompositionSource

    @JvmInline
    value class Json(val json: String) : LottieCompositionSource

    @JvmInline
    value class Provider(val contentUri: Uri) : LottieCompositionSource
}
*/

package com.splanes.komposier.component.catalog.snackbar.ui.view

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.SnackbarDuration
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.RecomposeScope
import androidx.compose.runtime.State
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.AccessibilityManager
import androidx.compose.ui.platform.LocalAccessibilityManager
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.dismiss
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.semantics
import com.splanes.komposier.component.catalog.snackbar.model.SnackbarUiData
import com.splanes.komposier.component.catalog.snackbar.tokens.SnackbarTokens
import com.splanes.komposier.component.catalog.snackbar.ui.state.SnackbarState
import kotlinx.coroutines.delay

@Composable
fun SnackbarHost(
    snackbarState: SnackbarState,
    modifier: Modifier = Modifier,
    snackbar: @Composable (SnackbarUiData) -> Unit = { Snackbar(it) }
) {
    val currentSnackbarData = snackbarState.snackbarUiData
    val accessibilityManager = LocalAccessibilityManager.current
    LaunchedEffect(currentSnackbarData) {
        if (currentSnackbarData != null) {
            val duration = currentSnackbarData.visuals.duration.toMillis(
                currentSnackbarData.visuals.actionLabel != null,
                accessibilityManager
            )
            delay(duration)
            currentSnackbarData.dismiss()
        }
    }
    FadeInFadeOutWithScale(
        current = snackbarState.snackbarUiData,
        modifier = modifier,
        content = snackbar
    )
}


// TODO: magic numbers adjustment
internal fun SnackbarDuration.toMillis(
    hasAction: Boolean,
    accessibilityManager: AccessibilityManager?
): Long {
    val original = when (this) {
        SnackbarDuration.Indefinite -> Long.MAX_VALUE
        SnackbarDuration.Long -> 10000L
        SnackbarDuration.Short -> 4000L
    }
    if (accessibilityManager == null) {
        return original
    }
    return accessibilityManager.calculateRecommendedTimeoutMillis(
        original,
        containsIcons = true,
        containsText = true,
        containsControls = hasAction
    )
}

// TODO: to be replaced with the public customizable implementation
// it's basically tweaked nullable version of Crossfade
@OptIn(ExperimentalAnimationApi::class)
@Composable
private fun FadeInFadeOutWithScale(
    current: SnackbarUiData?,
    modifier: Modifier = Modifier,
    content: @Composable (SnackbarUiData) -> Unit
) {
    val state = remember { FadeInFadeOutState<SnackbarUiData?>() }
    if (current != state.current) {
        state.current = current
        val keys = state.items.map { it.key }.toMutableList()
        if (!keys.contains(current)) {
            keys.add(current)
        }
        state.items.clear()
        keys.filterNotNull().mapTo(state.items) { key ->
            FadeInFadeOutAnimationItem(key) { children ->
                val isVisible = key == current
                val duration = if (isVisible) SnackbarEnterTransitionMillis else SnackbarExitTransitionMillis
                val opacity by animatedOpacity(
                    animation = tween(
                        easing = LinearEasing,
                        durationMillis = duration
                    ),
                    visible = isVisible,
                    onAnimationFinish = {
                        if (key != state.current) {
                            // leave only the current in the list
                            state.items.removeAll { it.key == key }
                            state.scope?.invalidate()
                        }
                    }
                )
                Box(
                    modifier = Modifier
                        .graphicsLayer(alpha = opacity)
                        .semantics {
                            liveRegion = LiveRegionMode.Polite
                            dismiss { key.dismiss(); true }
                        },
                    content = {
                        var visible by remember { mutableStateOf(false) }
                        Column {
                            children()
                            AnimatedVisibility(
                                visible = visible,
                                enter = expandVertically(
                                    animationSpec = spring(
                                        SnackbarSpringDampingRatio,
                                        Spring.StiffnessMediumLow
                                    )
                                ),
                                exit = shrinkVertically(
                                    animationSpec = tween(durationMillis = SnackbarExitTransitionMillis)
                                )
                            ) {
                                Spacer(modifier = Modifier.height(SnackbarTokens.ContainerBottomPadding))
                            }
                            LaunchedEffect(isVisible) {
                                delay(SnackbarTranslationDelayMillis)
                                visible = isVisible
                            }
                        }
                    }
                )
            }
        }
    }
    Box(modifier) {
        state.scope = currentRecomposeScope
        state.items.forEach { (item, opacity) ->
            key(item) {
                opacity { content(item!!) }
            }
        }
    }
}

private class FadeInFadeOutState<T> {
    // we use Any here as something which will not be equals to the real initial value
    var current: Any? = Any()
    var items = mutableListOf<FadeInFadeOutAnimationItem<T>>()
    var scope: RecomposeScope? = null
}

private data class FadeInFadeOutAnimationItem<T>(
    val key: T,
    val transition: FadeInFadeOutTransition
)

private typealias FadeInFadeOutTransition = @Composable (content: @Composable () -> Unit) -> Unit

@Composable
private fun animatedOpacity(
    animation: AnimationSpec<Float>,
    visible: Boolean,
    onAnimationFinish: () -> Unit = {}
): State<Float> {
    val alpha = remember { Animatable(if (!visible) 1f else 0f) }
    LaunchedEffect(visible) {
        alpha.animateTo(
            if (visible) 1f else 0f,
            animationSpec = animation
        )
        onAnimationFinish()
    }
    return alpha.asState()
}

private const val SnackbarEnterTransitionMillis = 300
private const val SnackbarSpringDampingRatio = .425f
private const val SnackbarExitTransitionMillis = 200
private const val SnackbarTranslationDelayMillis = 15L

package com.splanes.komposier.ui.toolkit.anims.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

data class TransitionSet(
    val enter: EnterTransition,
    val exit: ExitTransition
)

infix fun EnterTransition.setWith(exit: ExitTransition): TransitionSet = TransitionSet(enter = this, exit)

infix fun ExitTransition.setWith(enter: EnterTransition): TransitionSet = enter setWith this

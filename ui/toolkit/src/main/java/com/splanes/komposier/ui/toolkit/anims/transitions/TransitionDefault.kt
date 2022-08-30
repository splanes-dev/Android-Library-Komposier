package com.splanes.komposier.ui.toolkit.anims.transitions

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition

fun EnterTransition?.orNone(): EnterTransition = this ?: EnterTransition.None
fun ExitTransition?.orNone(): ExitTransition = this ?: ExitTransition.None

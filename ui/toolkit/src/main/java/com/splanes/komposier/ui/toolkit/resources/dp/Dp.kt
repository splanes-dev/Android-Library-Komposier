package com.splanes.komposier.ui.toolkit.resources.dp

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.commons.reflect.get
import com.splanes.komposier.commons.reflect.set
import com.splanes.komposier.commons.scope.defaults.to
import kotlin.reflect.KMutableProperty

inline fun <reified N : Number> Dp.value(): N = value.to(N::class)

inline fun <reified N : Number> dp(crossinline block: () -> N) = block().toDouble().dp

operator fun <N : Number> Dp.plus(other: N): Dp =
    dp { value<Double>() + other.toDouble() }

operator fun <N : Number> KMutableProperty<Dp>.plusAssign(other: N) =
    set(get() + other)

operator fun <N : Number> Dp.minus(other: N): Dp =
    dp { value<Double>() - other.toDouble() }

operator fun <N : Number> KMutableProperty<Dp>.minusAssign(other: N) =
    set(get() - other)
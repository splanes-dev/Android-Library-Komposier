package com.splanes.komposier.ui.toolkit.resources.sp

import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.splanes.komposier.commons.reflect.get
import com.splanes.komposier.commons.reflect.set
import com.splanes.komposier.commons.scope.defaults.to
import kotlin.reflect.KMutableProperty

inline fun <reified N : Number> TextUnit.value(): N = value.to(N::class)

inline fun <reified N : Number> sp(crossinline block: () -> N) = block().toDouble().sp

operator fun <N : Number> TextUnit.plus(other: N): TextUnit =
    sp { value<Double>() + other.toDouble() }

operator fun <N : Number> KMutableProperty<TextUnit>.plusAssign(other: N) =
    set(get() + other)

operator fun <N : Number> TextUnit.minus(other: N): TextUnit =
    sp { value<Double>() - other.toDouble() }

operator fun <N : Number> KMutableProperty<TextUnit>.minusAssign(other: N) =
    set(get() - other)
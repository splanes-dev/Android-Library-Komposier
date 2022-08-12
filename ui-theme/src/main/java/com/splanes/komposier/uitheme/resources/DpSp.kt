package com.splanes.komposier.uitheme.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.commons.reflect.get
import com.splanes.komposier.commons.reflect.set
import com.splanes.komposier.uitheme.theme.Paddings
import com.splanes.komposier.uitheme.theme.paddings.ThemePaddings
import kotlin.reflect.KMutableProperty

inline val Dp.valueInt: Int get() = value.toInt()
inline val Dp.valueDouble: Double get() = value.toDouble()

inline fun <reified N : Number> dp(crossinline block: () -> N) = block().toDouble().dp

@Composable
inline fun padding(block: ThemePaddings.() -> Dp) =
    block(Paddings)

operator fun <N : Number> Dp.plus(other: N): Dp =
    dp { valueDouble + other.toDouble() }

operator fun <N : Number> KMutableProperty<Dp>.plusAssign(other: N) =
    set(get() + other)

operator fun <N : Number> Dp.minus(other: N): Dp =
    dp { valueDouble - other.toDouble() }

operator fun <N : Number> KMutableProperty<Dp>.minusAssign(other: N) =
    set(get() - other)




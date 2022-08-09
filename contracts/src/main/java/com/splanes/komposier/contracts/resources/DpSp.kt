package com.splanes.komposier.contracts.resources

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.splanes.komposier.contracts.theme.Paddings
import com.splanes.komposier.contracts.theme.paddings.ThemePaddings
import kotlin.reflect.KMutableProperty


inline fun dp(crossinline block: () -> Double) = block().dp

fun dp(value: Double) = dp{ value }

fun dp(value: Int) = dp(value.toDouble())

@Composable
inline fun padding(crossinline block: ThemePaddings.() -> Dp) = block(Paddings)

operator fun Dp.plus(other: Int): Dp = this + dp(other)
operator fun Dp.plus(other: Double): Dp = this + dp(other)
operator fun Dp.plusAssign(other: Double) {
    this += dp(other)
}
operator fun KMutableProperty<Dp>.plusAssign(other: Int)  {
   setter.call(dp(other))
}
operator fun Dp.minus(other: Int): Dp = this - dp(other)
operator fun Dp.minus(other: Double): Dp = this - dp(other)
operator fun Dp.minus(other: Double): Dp = this - dp(other)
operator fun Dp.minus(other: Double): Dp = this - dp(other)




package com.splanes.komposier.ui.toolkit.texts.textstyle

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.splanes.komposier.commons.primitives.numbers.coerceAtLeast
import com.splanes.komposier.commons.reflect.get
import com.splanes.komposier.commons.reflect.set
import com.splanes.komposier.ui.toolkit.resources.sp.minus
import com.splanes.komposier.ui.toolkit.resources.sp.plus
import kotlin.reflect.KMutableProperty

operator fun <N : Number> TextStyle.plus(fontSize: N) =
    copy(fontSize = this.fontSize + fontSize)

operator fun TextStyle.inc() =
    copy(fontSize = this.fontSize + 1)

operator fun <N : Number> TextStyle.minus(fontSize: N) =
    copy(fontSize = coerceAtLeast(min = 0) { this.fontSize.value - fontSize.toFloat() }.sp)

operator fun TextStyle.dec() =
    copy(fontSize = this.fontSize - 1)

@JvmName("plusAssignFontSize")
operator fun KMutableProperty<TextStyle>.plusAssign(fontSize: () -> TextUnit) {
    set(get().copy(fontSize = fontSize()))
}

@JvmName("plusAssignFontFamily")
operator fun KMutableProperty<TextStyle>.plusAssign(fontFamily: () -> FontFamily?) {
    set(get().copy(fontFamily = fontFamily()))
}
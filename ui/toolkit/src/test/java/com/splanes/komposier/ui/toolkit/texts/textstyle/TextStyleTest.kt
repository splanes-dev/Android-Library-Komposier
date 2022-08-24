package com.splanes.komposier.ui.toolkit.texts.textstyle

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp
import org.junit.Assert.assertEquals
import org.junit.Test

class TextStyleTest {


    @Test
    fun `given any TextStyle, when operator plus called, then result to a TextStyle with fontSize + other`() {
        val given = AnyTextStyle
        val fontSizeIncrement = 3

        val result = given + fontSizeIncrement

        val expected = AnyTextStyle.fontSize.value + fontSizeIncrement
        assertEquals(expected, result.fontSize.value)
    }

    @Test
    fun `given any TextStyle, when operator minus called, then result to a TextStyle with fontSize - other`() {
        val given = AnyTextStyle
        val fontSizeIncrement = 3

        val result = given + fontSizeIncrement

        val expected = AnyTextStyle.fontSize.value + fontSizeIncrement
        assertEquals(expected, result.fontSize.value)
    }
}

private val AnyTextStyleFontSize = 13.sp
private val AnyTextStyle = TextStyle(fontSize = AnyTextStyleFontSize)
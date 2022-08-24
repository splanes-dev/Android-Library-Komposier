package com.splanes.komposier.commons.primitives.numbers

import org.junit.Assert.assertEquals
import org.junit.Test

class CoerceTest {

    @Test
    fun `given a math operation, when result is min than coerced, then result is coerced at min given`() {
        val given: () -> Int = { 2 - 3 }
        val min = 1

        val result = coerceAtLeast(min = min) { given() }

        assertEquals(min, result)
    }

    @Test
    fun `given a math operation, when result is equals o greater than coerced, then result is not coerced`() {
        val given: () -> Int = { 3 - 1 }
        val expected = 2
        val min = 1

        val result = coerceAtLeast(min = min) { given() }

        assertEquals(expected, result)
    }

    @Test
    fun `given a math operation, when result is greater than coerced, then result is coerced at max given`() {
        val given: () -> Int = { 6 + 3 }
        val max = 5

        val result = coerceAtMost(max = max) { given() }

        assertEquals(max, result)
    }

    @Test
    fun `given a math operation, when result is equals o less than coerced, then result is not coerced`() {
        val given: () -> Int = { 3 + 1 }
        val expected = 4
        val max = 7

        val result = coerceAtMost(max = max) { given() }

        assertEquals(expected, result)
    }
}
package com.splanes.komposier.commons.primitives.texts

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.random.Random

class RemoveTest {

    @Test
    fun `given any string, when removing just the first desired char, then the string is updated as expected`() {
        val anyString = AnyText
        val someChar = "a"

        val result = anyString.removeFirst(someChar)

        assertNotNull(result)
        assertTrue(result.isNotBlank())
        assertNotEquals(anyString, result)
        assertEquals(anyString.count() - 1, result.count())
    }

    @Test
    fun `given any string, when removing single existing single char, then the string is updated as expected`() {
        val anyString = AnyText
        val singleExistingChar = "="

        val result = anyString.removeAll(singleExistingChar)

        assertNotNull(result)
        assertTrue(result.isNotBlank())
        assertFalse(result.contains(singleExistingChar))
    }

    @Test
    fun `given any string, when removing multiple existing single char, then the string is updated as expected`() {
        val anyString = AnyText
        val multipleExistingChar = "e"

        val resultSensitive = anyString.removeAll(multipleExistingChar)
        val resultInsensitive = anyString.removeAll(multipleExistingChar, ignoreCase = true)

        assertNotNull(resultSensitive)
        assertNotNull(resultInsensitive)
        assertTrue(resultSensitive.isNotBlank())
        assertTrue(resultInsensitive.isNotBlank())

        assertFalse(resultSensitive.contains(multipleExistingChar))
        assertTrue(resultSensitive.contains(multipleExistingChar.uppercase()))

        assertFalse(resultInsensitive.contains(multipleExistingChar))
        assertFalse(resultInsensitive.contains(multipleExistingChar.uppercase()))
    }

    @Test
    fun `given any string, when removing non-existing char, then the string is not updated`() {
        val anyString = AnyText
        val nonExistingChar = "&"

        val result = anyString.removeAll(nonExistingChar)

        assertNotNull(result)
        assertTrue(result.isNotBlank())
        assertEquals(anyString, result)
    }

    @Test
    fun `given any string, when removing char at valid index, then string is updated as expected`() {
        val anyString = AnyText
        val positionToRemove = Random.nextInt(until = anyString.length)
        val expectedCharToRemove = anyString[positionToRemove]

        val result = anyString.removeAt(positionToRemove)

        assertNotNull(result)
        assertTrue(result.isNotBlank())
        assertEquals(anyString.count() - 1, result.count())
        assertNotEquals(expectedCharToRemove, result[positionToRemove])
        anyString.getOrNull(positionToRemove + 1)?.let { expected ->
            assertEquals(expected, result[positionToRemove])
        }
    }
}

private const val AnyText =
    "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit, = SED DO EIUSMOD TEMPOR INCIDIDUNT Ut Labore Et " +
        "Dolore Magna Aliqua."

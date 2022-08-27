package com.splanes.komposier.commons.uuid

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import java.util.UUID

class UniqueIdTest {

    private lateinit var randomStyle: UniqueId.Style

    @Before
    fun initRandomStyle() {
        this.randomStyle = listOf(UniqueIdStyle.NoDash, UniqueIdStyle.Length()).shuffled().first()
    }

    @Test
    fun `given an UniqueId Style, when applied, then result is as expected`() {
        // given randomStyle
        val style = UniqueIdStyle.NoDash
        val uuid = AnyUUID

        val result = style.apply(uuid = uuid)

        assertNotNull(result)
        assertTrue(result.isNotBlank())
        when (style) {
            UniqueIdStyle.NoDash -> {
                assertEquals(AnyUUID.toString().count() - 4, result.count())
                assertFalse(result.contains("-"))
            }
            /*is UniqueIdStyle.Length -> {
                assertEquals(style.length.value, result.count())
                assertFalse(result.contains("-"))
            }*/
        }
    }

    @Test
    fun `given 2 uuid request, when gen by UniqueId obj, then they are not equals`() {
        val one = UniqueId.next()
        val other = UniqueId.next()

        assertNotNull(one)
        assertNotNull(other)
        assertTrue(one.isNotBlank())
        assertTrue(other.isNotBlank())
        assertNotEquals(one, other)
    }
}

private val AnyUUID = UUID.randomUUID()

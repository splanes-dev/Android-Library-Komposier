package com.splanes.komposier.ui.toolkit.texts.capitalizations

import com.splanes.komposier.ui.toolkit.texts.capitalization.Capitalization
import com.splanes.komposier.ui.toolkit.texts.capitalization.capitalize
import com.splanes.komposier.ui.toolkit.texts.capitalization.capitalizeStrict
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test


class CapitalizationTest {

    private lateinit var givenString: String

    @Before
    fun shuffleGivenString() {
        givenString = listOf(
            LowercaseText,
            UppercaseText,
            WordCapitalizedText,
            SentenceCapitalizedText
        ).shuffled().first()
    }

    @Test
    fun `given empty string, when applied any capitalization, the result is also the empty string`() {
        givenString = EmptyString

        val result = givenString.capitalize(Capitalization.Uppercase)

        assertNotNull(result)
        assertTrue(result.isEmpty())
        assertEquals(EmptyString, result)
    }

    @Test
    fun `given any string, when applied lowercase capitalization, it results as expected`() {
        val result = givenString.capitalizeStrict(Capitalization.Lowercase)

        result.assertCapitalization(Capitalization.Lowercase)
    }

    @Test
    fun `given any string, when applied uppercase capitalization, it results as expected`() {
        val result = givenString.capitalizeStrict(Capitalization.Uppercase)

        result.assertCapitalization(Capitalization.Uppercase)
    }

    @Test
    fun `given any string, when applied words capitalization, it results as expected`() {
        val result = givenString.capitalizeStrict(Capitalization.Words)

        result.assertCapitalization(Capitalization.Words)
    }

    @Test
    fun `given any string, when applied sentence capitalization, it results as expected`() {
        val result = givenString.capitalizeStrict(Capitalization.Sentences)

        result.assertCapitalization(Capitalization.Sentences)
    }

    @Test
    fun `given any random capitalized string, when applied any capitalization, it results as expected`() {
        givenString = RandomCapitalizedShortText

        val anyCapitalization = Capitalization.values().apply { shuffle() }.first()
        val result = givenString.capitalize(anyCapitalization)


        val expected = when (anyCapitalization) {
            Capitalization.Lowercase -> LowercaseText
            Capitalization.Words -> getRandomTextWithWordCaps()
            Capitalization.Sentences -> getRandomTextWithSentenceCaps()
            Capitalization.Uppercase -> UppercaseText
        }
        assertNotNull(result)
        assertEquals(expected, result)
    }

    private fun String?.assertCapitalization(capitalization: Capitalization) {
        assertNotNull(this)
        assertEquals(getSampleTextOf(capitalization), this)
    }

    private fun getSampleTextOf(capitalization: Capitalization) = when (capitalization) {
        Capitalization.Lowercase -> LowercaseText
        Capitalization.Words -> WordCapitalizedText
        Capitalization.Sentences -> SentenceCapitalizedText
        Capitalization.Uppercase -> UppercaseText
    }

    private fun getRandomTextWithWordCaps() =
        "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit, SED DO EIUSMOD TEMPOR INCIDIDUNT Ut Labore Et " +
                "Dolore Magna Aliqua."

    private fun getRandomTextWithSentenceCaps() =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, SED DO EIUSMOD TEMPOR INCIDIDUNT ut labore et " +
                "Dolore Magna Aliqua."
}

private const val EmptyString = ""

private const val LowercaseText =
    "lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
            "dolore magna aliqua."

private const val UppercaseText =
    "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISCING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET " +
            "DOLORE MAGNA ALIQUA."

private const val WordCapitalizedText =
    "Lorem Ipsum Dolor Sit Amet, Consectetur Adipiscing Elit, Sed Do Eiusmod Tempor Incididunt Ut Labore Et " +
            "Dolore Magna Aliqua."

private const val SentenceCapitalizedText =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et " +
            "dolore magna aliqua."

private const val RandomCapitalizedShortText =
    "Lorem ipsum dolor sit amet, consectetur adipiscing elit, SED DO EIUSMOD TEMPOR INCIDIDUNT ut labore et " +
            "Dolore Magna Aliqua."
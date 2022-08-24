package com.splanes.komposier.ui.toolkit.texts.capitalization

fun String.capitalize(capitalization: Capitalization): String = when (capitalization) {
    Capitalization.Lowercase -> lowercase()
    Capitalization.Words -> replace(Regex(Capitalization.WORD_PATTERN)) { result -> result.value.uppercase() }
    Capitalization.Sentences -> replace(Regex(Capitalization.SENTENCE_PATTERN)) { result -> result.value.uppercase() }
    Capitalization.Uppercase -> uppercase()
}

fun String.capitalizeStrict(capitalization: Capitalization): String = lowercase().capitalize(capitalization)
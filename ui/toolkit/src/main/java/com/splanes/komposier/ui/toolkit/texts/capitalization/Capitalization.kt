package com.splanes.komposier.ui.toolkit.texts.capitalization

import org.intellij.lang.annotations.Language

enum class Capitalization {
    Lowercase,
    Words,
    Sentences,
    Uppercase,

    ;

    companion object {
        @field:Language("RegExp")
        const val SENTENCE_PATTERN = "(^!?\\w)|(!?\\.\\s\\w)|(!?\\n\\w)"
        @field:Language("RegExp")
        const val WORD_PATTERN = "(^!?\\w)|(\\s\\w)"
    }
}
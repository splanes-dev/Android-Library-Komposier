package com.splanes.komposier.commons.primitives.texts

val String.Companion.Empty get() = ""

fun String.removeFirst(old: String, ignoreCase: Boolean = false): String =
    replaceFirst(old, String.Empty, ignoreCase = ignoreCase)

fun String.removeAll(old: String, ignoreCase: Boolean = false): String =
    replace(old, String.Empty, ignoreCase = ignoreCase)

fun String.removeAt(index: Int): String =
    removeRange(index..index)

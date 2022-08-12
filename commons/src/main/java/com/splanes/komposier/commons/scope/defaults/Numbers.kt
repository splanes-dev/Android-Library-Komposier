package com.splanes.komposier.commons.scope.defaults

import com.splanes.komposier.commons.errors.ErrorLogger
import com.splanes.komposier.commons.errors.GenericException

class NumberDefaultException(numClass: String?) :
    RuntimeException(),
    ErrorLogger by ErrorLogger.Delegate() {

    override val message: String =
        "Number default for class `$numClass` is not supported."
}

inline fun <reified N : Number> numberDefaultOf(): N =
    when (N::class) {
        Int::class -> 0 as N
        Float::class -> 0f as N
        Double::class -> 0.0 as N
        Long::class -> 0L as N
        Short::class -> 0.toShort() as N
        else -> NumberDefaultException(N::class.simpleName).`throw`()
    }

inline fun <reified N : Number> N?.orDefault(): N =
    this ?: numberDefaultOf()

fun <N : Number> N?.orThrow(error: Throwable = GenericException()): N =
    this ?: when (error) {
        is ErrorLogger -> error.`throw`()
        else -> throw error
    }

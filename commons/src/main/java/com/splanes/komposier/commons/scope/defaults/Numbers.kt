package com.splanes.komposier.commons.scope.defaults

import com.splanes.komposier.commons.errors.BaseException
import com.splanes.komposier.commons.errors.GenericException
import kotlin.reflect.KClass

class NumberDefaultException(numClass: String?) : BaseException() {
    override val message: String =
        "Number default for class `$numClass` is not supported."
}

class NumbersCastException(from: String?, to: String?) : BaseException() {
    override val message: String =
        "Impossible to cast number type `$from` to type `$to`. Operation not supported."
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
        is BaseException -> error.`throw`()
        else -> throw error
    }

@Suppress("UNCHECKED_CAST")
fun <N1 : Number, N2 : Number> N1.to(klass: KClass<N2>): N2 =
    when (klass) {
        Int::class -> toInt() as N2
        Float::class -> toFloat() as N2
        Double::class -> toDouble() as N2
        Long::class -> toLong() as N2
        Short::class -> toShort() as N2
        else -> NumbersCastException(this::class.simpleName, klass.simpleName).`throw`()
    }

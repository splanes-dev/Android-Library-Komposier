package com.splanes.komposier.commons.tag

import kotlin.reflect.KClass

object Tag {
    fun <T : Any> of(any: T): String =
        any::class.simpleName
            ?: NullTagException("Couldn't get simpleName property from object: $any").`throw`()
}

inline val <T : Any> KClass<T>.tag: String get() =
    simpleName ?: NullTagException("Couldn't get simpleName property from object: $this").`throw`()

inline val <T : Any> T.tag: String
    get() = this::class.simpleName
        ?: NullTagException("Couldn't get simpleName property from object: $this").`throw`()
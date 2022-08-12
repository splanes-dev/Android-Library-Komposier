package com.splanes.komposier.commons.tag

object Tag {
    fun <T : Any> of(any: T) =
        any::class.simpleName
            ?: NullTagException("Couldn't get simpleName property from object: $any").`throw`()
}

inline val <T : Any> T.tag: String
    get() = this::class.simpleName
        ?: NullTagException("Couldn't get simpleName property from object: $this").`throw`()
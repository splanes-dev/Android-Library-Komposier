package com.splanes.komposier.commons.uuid

sealed interface PK {
    val uuid: String
    val name: String

    private class Impl(override val name: String) : PK {
        override val uuid: String = UniqueId.next()
    }

    companion object {
        internal fun of(name: String): PK = Impl(name)
    }
}

package com.splanes.komposier.commons.errors

class GenericException(private val msg: String? = null) : BaseException() {

    override val message: String by lazy { msg ?: "Generic error, no more details provided..." }
}

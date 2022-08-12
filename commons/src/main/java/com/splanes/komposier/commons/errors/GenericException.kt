package com.splanes.komposier.commons.errors

open class GenericException(open val msg: String? = null) :
    RuntimeException(),
    ErrorLogger by ErrorLogger.Delegate() {

    override val message: String by lazy { msg ?: "Generic error, no more details provided..." }
}

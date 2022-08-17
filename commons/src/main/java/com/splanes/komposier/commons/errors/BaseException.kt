package com.splanes.komposier.commons.errors

abstract class BaseException(
    override val message: String? = null,
    override val cause: Throwable? = null
) : Throwable(message, cause),
    ErrorObservable by ErrorObservable.Delegate() {

    private var _isInit = false

    fun `throw`(): Nothing {
        if (!_isInit) ErrorLogger.init(this).also { _isInit = true }
        notify(this)
        throw this
    }
}
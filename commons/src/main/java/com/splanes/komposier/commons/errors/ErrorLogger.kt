package com.splanes.komposier.commons.errors

import timber.log.Timber

object ErrorLogger : ErrorObserver {
    fun init(error: ErrorObservable) {
        error.addObserver(this)
    }

    override fun onErrorThrown(error: Throwable) {
        Timber.v("Exception `${error::class.simpleName}` was thrown.")
    }
}
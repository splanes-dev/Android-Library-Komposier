package com.splanes.komposier.commons.errors

import timber.log.Timber

interface ErrorLogger {
    fun bind(throwable: Throwable)
    fun `throw`(): Nothing

    class Delegate : ErrorLogger, ErrorObservable {

        private lateinit var _throwable: Throwable
        override val observers: MutableList<ErrorObserver> = mutableListOf()

        override fun bind(throwable: Throwable) {
            this._throwable = throwable
        }

        override fun `throw`(): Nothing {
            Timber.v("Exception `${_throwable::class.simpleName}` was thrown.")
            notify(error = _throwable)
            throw _throwable
        }
    }
}
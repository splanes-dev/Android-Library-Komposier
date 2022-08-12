package com.splanes.komposier.commons.errors

interface ErrorObserver {
    fun onErrorThrown(error: Throwable)
}
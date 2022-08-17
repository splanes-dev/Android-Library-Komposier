package com.splanes.komposier.commons.errors

interface ErrorObservable {
    val observers: MutableList<ErrorObserver>
    fun addObserver(observer: ErrorObserver) {
        observers.remove(observer)
        observers.add(observer)
    }

    fun notify(error: Throwable) {
        observers.forEach { it.onErrorThrown(error) }
    }

    class Delegate : ErrorObservable {
        override val observers: MutableList<ErrorObserver> = mutableListOf()
    }
}
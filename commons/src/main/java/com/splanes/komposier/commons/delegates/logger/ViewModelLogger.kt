package com.splanes.komposier.commons.delegates.logger

import timber.log.Timber

interface ViewModelLogger {
    fun log(event: Event)
    enum class Event {
        OnCreated,
        OnCleared,
    }
    companion object {
        val OnCreated = Event.OnCreated
        val OnCleared = Event.OnCleared
    }
}

class ViewModelLoggerDelegate(private val tag: String) : ViewModelLogger {
    override fun log(event: ViewModelLogger.Event) {
        when (event) {
            ViewModelLogger.Event.OnCreated -> "ViewModel `$tag` (re)created"
            ViewModelLogger.Event.OnCleared -> "ViewModel `$tag` cleared"
        }.run(Timber::v)
    }
}

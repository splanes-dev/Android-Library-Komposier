package com.splanes.komposier.component.catalog.snackbar.ui.view

import androidx.lifecycle.ViewModel
import com.splanes.komposier.commons.delegates.logger.ViewModelLogger
import com.splanes.komposier.commons.delegates.logger.ViewModelLoggerDelegate
import com.splanes.komposier.commons.tag.tagOf
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob

@HiltViewModel
class SnackbarViewModel @Inject constructor() :
    ViewModel(),
    ViewModelLogger by ViewModelLoggerDelegate(tagOf<SnackbarViewModel>()),
    CoroutineScope {

    private val job = SupervisorJob()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main.immediate

    init {
        log(ViewModelLogger.OnCreated)
    }

    override fun onCleared() {
        log(ViewModelLogger.OnCleared)
        job.complete()
        super.onCleared()
    }
}
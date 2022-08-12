package com.splanes.komposier.commons.tag

import com.splanes.komposier.commons.errors.ErrorLogger

class NullTagException(override val message: String) :
    RuntimeException(),
    ErrorLogger by ErrorLogger.Delegate() {

   constructor(obj: Any) : this(message = MSG_TEMPLATE.format(obj.toString()))

    init {
        bind(this)
    }

    companion object {
        private const val MSG_TEMPLATE =
            "Couldn't get simpleName prop. from obj `%1\$s`. Unknown causes..."
    }
}
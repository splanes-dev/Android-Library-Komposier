package com.splanes.komposier.commons.tag

import com.splanes.komposier.commons.errors.BaseException

class NullTagException(override val message: String) :
    BaseException() {

   constructor(obj: Any) : this(message = MSG_TEMPLATE.format(obj.toString()))

    companion object {
        private const val MSG_TEMPLATE =
            "Couldn't get simpleName prop. from obj `%1\$s`. Unknown causes..."
    }
}
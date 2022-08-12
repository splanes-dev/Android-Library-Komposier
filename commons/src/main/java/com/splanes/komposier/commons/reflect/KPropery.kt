package com.splanes.komposier.commons.reflect

import kotlin.reflect.KProperty
import kotlin.reflect.KMutableProperty

fun <T> KProperty<T>.get(vararg args: Any?): T = getter.call(*args)
fun <T> KMutableProperty<T>.set(vararg args: Any?) = setter.call(*args)
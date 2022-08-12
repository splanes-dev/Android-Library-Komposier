package com.splanes.komposier.commons.scope.defaults


fun Function0<Unit>?.orEmpty(): Function0<Unit> =
    this ?: {}

fun <P1> Function1<P1, Unit>?.orEmpty(): Function1<P1, Unit> =
    this ?: {}

fun <P1, P2> Function2<P1, P2, Unit>?.orEmpty(): Function2<P1, P2, Unit> =
    this ?: { _, _ -> }

fun <T> Function0<T>?.orDefault(default: T): Function0<T> =
    this ?: { default }

fun <P1, T> Function1<P1, T>?.orDefault(default: T): Function1<P1, T> =
    this ?: { default }

fun <P1, P2, T> Function2<P1, P2, T>?.orDefault(default: T): Function2<P1, P2, T> =
    this ?: { _, _ -> default }
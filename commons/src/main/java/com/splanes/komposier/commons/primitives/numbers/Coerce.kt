package com.splanes.komposier.commons.primitives.numbers

import com.splanes.komposier.commons.scope.defaults.to

inline fun <N1 : Number, N2 : Number> coerceAtLeast(min: N1, crossinline block: () -> N2): N2 =
    block().let { r -> r.takeUnless { n -> n < min } ?: min.to(r::class) }

inline fun <N1 : Number, N2 : Number> coerceAtMost(max: N1, crossinline block: () -> N2): N2 =
    block().let { r -> r.takeUnless { n -> n > max } ?: max.to(r::class) }
package com.splanes.komposier.commons.primitives.numbers

operator fun <N : Number> N.compareTo(other: N): Int =
    this.toDouble().compareTo(other.toDouble())

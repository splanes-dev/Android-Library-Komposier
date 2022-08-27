package com.splanes.komposier.commons.uuid

import com.splanes.komposier.commons.primitives.texts.removeAll
import com.splanes.komposier.commons.primitives.texts.removeAt
import java.util.UUID
import kotlin.random.Random

object UniqueId {

    fun primaryKeyOf(name: String) = PK.of(name)

    fun next(style: Style = UniqueIdStyle.NoDash): String = UUID.randomUUID().run(style::apply)

    sealed interface Style {
        fun apply(uuid: UUID): String
    }

    enum class Length(val value: Int) {
        Short(value = 24),
        Large(value = 48),
    }
}

val UniqueId.Short: UniqueId.Length get() = UniqueId.Length.Short
val UniqueId.Large: UniqueId.Length get() = UniqueId.Length.Large

sealed interface UniqueIdStyle {
    object NoDash : UniqueId.Style {
        override fun apply(uuid: UUID): String = uuid.toString().removeAll("-")
    }

    @JvmInline
    value class Length(val length: UniqueId.Length = UniqueId.Short) : UniqueId.Style {
        override fun apply(uuid: UUID): String {
            var uuidShorten = NoDash.apply(uuid)
            while (uuidShorten.length > length.value) {
                val index = Random.nextInt(until = uuidShorten.count())
                uuidShorten = uuidShorten.removeAt(index)
            }
            return uuidShorten
        }
    }
}

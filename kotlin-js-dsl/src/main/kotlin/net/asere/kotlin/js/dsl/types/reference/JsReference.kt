package net.asere.kotlin.js.dsl.types.reference

import net.asere.kotlin.js.dsl.types.value.JsValue

interface JsReference<T : JsValue> : JsValue {
    val name: String

    companion object {
        private var currentStringRefId = 0
        internal fun nextRefInt(): Int = currentStringRefId++
    }
}
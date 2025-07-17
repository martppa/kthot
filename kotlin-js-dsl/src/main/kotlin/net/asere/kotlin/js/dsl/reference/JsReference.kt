package net.asere.kotlin.js.dsl.reference

import net.asere.kotlin.js.dsl.value.JsValue

interface JsReference<T : JsValue> : JsValue {
    val name: String

    companion object {
        private var currentStringRefId = 0
        internal fun nextRefInt(): Int = currentStringRefId++
    }
}
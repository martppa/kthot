package net.asere.kotlin.js.dsl.type

import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsObject : JsValue {
    override fun toString(): String = present()
    companion object
}
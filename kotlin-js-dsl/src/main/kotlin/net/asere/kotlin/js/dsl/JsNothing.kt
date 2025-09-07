package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.type.value.JsValue

class JsNothing internal constructor() : JsValue {

    override fun present(): String = throw IllegalStateException("You can't print Nothing!")
}
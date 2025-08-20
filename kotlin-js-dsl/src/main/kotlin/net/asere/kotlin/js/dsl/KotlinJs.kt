package net.asere.kotlin.js.dsl

import net.asere.kotlin.js.dsl.provider.register
import net.asere.kotlin.js.dsl.type.bool.JsBoolean
import net.asere.kotlin.js.dsl.type.bool.syntax
import net.asere.kotlin.js.dsl.type.error.JsError
import net.asere.kotlin.js.dsl.type.error.syntax
import net.asere.kotlin.js.dsl.type.number.JsNumber
import net.asere.kotlin.js.dsl.type.number.syntax
import net.asere.kotlin.js.dsl.type.obj.JsObject
import net.asere.kotlin.js.dsl.type.obj.syntax
import net.asere.kotlin.js.dsl.type.string.JsString
import net.asere.kotlin.js.dsl.type.string.syntax

object KotlinJs : JsDsl {
    override fun initialize() {
        register(builder = JsString::syntax)
        register(builder = JsNumber::syntax)
        register(builder = JsBoolean::syntax)
        register(builder = JsError::syntax)
        register(builder = JsObject::syntax)
    }
}
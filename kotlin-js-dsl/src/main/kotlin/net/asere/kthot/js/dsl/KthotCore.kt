package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.provider.register
import net.asere.kthot.js.dsl.syntax.JsGenerics
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.error.JsError
import net.asere.kthot.js.dsl.type.error.syntax
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.number.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

open class KthotCore : KthotLib {
    override fun initialize() {
        register(builder = JsString::syntax)
        register(builder = JsNumber::syntax)
        register(builder = JsBoolean::syntax)
        register(builder = JsError::syntax)
        register(builder = JsObject::syntax)
        register(builder = JsNothing::syntax)
        register<JsReference<JsValue>>(JsGenerics::syntax)
        register<JsValue>(JsGenerics::syntax)
    }

    companion object {
        fun initialize() = object : KthotCore() {}.initialize()
    }
}
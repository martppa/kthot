package net.asere.kthot.js.dsl.type.namespace

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.syntax.operational.access.operation.ChainOperation
import net.asere.kthot.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kthot.js.dsl.type.bool.JsBoolean
import net.asere.kthot.js.dsl.type.bool.syntax
import net.asere.kthot.js.dsl.type.obj.JsObject
import net.asere.kthot.js.dsl.type.obj.JsObjectRef
import net.asere.kthot.js.dsl.type.obj.syntax
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.string.syntax
import net.asere.kthot.js.dsl.type.value.JsValue

object JSON : JsObjectRef("JSON") {
    fun isRawJSON(value: JsValue): JsBoolean = JsBoolean.syntax(ChainOperation(this, InvocationOperation("isRawJSON", value)))

    inline fun <reified T : JsValue> parse(value: JsValue): T = provide(ChainOperation(this, InvocationOperation("parse", value)))

    fun rawJSON(value: JsString): JsObject = JsObject.syntax(ChainOperation(this, InvocationOperation("rawJSON", value)))

    fun stringify(value: JsValue): JsString = JsString.syntax(ChainOperation(this, InvocationOperation("stringify", value)))
}
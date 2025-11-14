package net.asere.kthot.js.dsl.type.obj

import net.asere.kthot.js.dsl.syntax.operational.access.operation.AccessOperation
import net.asere.kthot.js.dsl.type.number.JsNumber
import net.asere.kthot.js.dsl.type.string.JsString
import net.asere.kthot.js.dsl.type.value.JsValue

interface JsObject : JsValue {
    companion object
}

operator fun JsObject.get(value: JsNumber) = JsObject.syntax(AccessOperation(this, value))
operator fun JsObject.get(value: JsString) = JsObject.syntax(AccessOperation(this, value))
operator fun JsObject.get(value: JsValue) = JsObject.syntax(AccessOperation(this, value))

package net.asere.kotlin.js.dsl.type.string

import net.asere.kotlin.js.dsl.type.toJsString
import net.asere.kotlin.js.dsl.type.value.JsValue

class JsStringHolderValue(
    value: String,
    vararg val params: JsValue,
) : JsStringValue(value) {

    override fun present(): String {
        var auxValue = value
        params.forEachIndexed { index, param ->
            auxValue = auxValue.replace("#$index", param.toJsString().stringify())
        }
        return "`$auxValue`"
    }

}

fun JsString.Companion.value(value: String, vararg params: JsString): JsString = JsStringHolderValue(value, *params)
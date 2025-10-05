package net.asere.kthot.js.dsl.type.string

import net.asere.kthot.js.dsl.type.toJsString
import net.asere.kthot.js.dsl.type.value.JsValue

internal class JsStringHolderValue(
    value: String,
    vararg val params: JsValue,
    val holder: String
) : JsStringValue(value) {

    override fun present(): String {
        var auxValue = value
        params.forEachIndexed { index, param ->
            auxValue = auxValue.replace("$holder$index", param.toJsString().stringify())
        }
        return "`$auxValue`"
    }

}

fun JsString.Companion.value(value: String, vararg params: JsValue, holder: String = "#"): JsString = JsStringHolderValue(value, *params, holder = holder)
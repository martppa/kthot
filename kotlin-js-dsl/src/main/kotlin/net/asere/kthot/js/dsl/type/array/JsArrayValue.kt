package net.asere.kthot.js.dsl.type.array

import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.value.JsRawValue
import net.asere.kthot.js.dsl.type.value.JsValue

class JsArrayValue<T : JsValue> private constructor(
    val value: JsSyntax
) : JsArray<T>, JsRawValue<JsArray<T>> {

    internal constructor(vararg values: T) : this(
        JsSyntax("[${values.joinToString(", ")}]")
    )

    internal constructor(values: List<T>) : this(
        JsSyntax("[${values.joinToString(", ")}]")
    )

    override fun present(): String = "$value"

    override fun toString(): String = present()

    companion object
}

fun <T : JsValue> JsArray.Companion.value(vararg values: T): JsArray<T> = JsArrayValue(*values)
fun <T : JsValue> JsArray.Companion.value(values: List<T>): JsArray<T> = JsArrayValue(values)
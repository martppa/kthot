package net.asere.kotlin.js.dsl.value

import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.type.JsCollection

class JsCollectionValue<T : JsValue> private constructor(
    val value: JsSyntax
) : JsCollection<T>(), JsRawValue<JsCollection<T>> {

    internal constructor(vararg values: T) : this(
        JsSyntax("[${values.joinToString(", ")}]")
    )

    internal constructor(values: List<T>) : this(
        JsSyntax("[${values.joinToString(", ")}]")
    )

    override fun present(): String = "$value"

    companion object
}

fun <T : JsValue> JsCollection.Companion.value(vararg values: T): JsCollection<T> = JsCollectionValue(*values)
fun <T : JsValue> JsCollection.Companion.value(values: List<T>): JsCollection<T> = JsCollectionValue(values)
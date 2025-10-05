@file:OptIn(JsInternalApi::class)

package net.asere.kthot.js.dsl

import net.asere.kthot.js.dsl.annotation.JsInternalApi
import net.asere.kthot.js.dsl.syntax.JsSyntax
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.obj.JsObjectValue
import net.asere.kthot.js.dsl.type.value.JsValue

interface JsNothing : JsValue {
    companion object
}

@JsInternalApi
open class JsNothingValue(
    value: JsElement
) : JsObjectValue(value), JsNothing

fun JsNothing.Companion.syntax(value: JsElement, unused: Boolean = false): JsNothing = JsNothingValue(value)

object JsEmpty : JsNothingValue(JsSyntax())
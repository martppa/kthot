package net.asere.kotlin.js.dsl.types.reference.function

import net.asere.kotlin.js.dsl.types.reference.JsObjectRef
import net.asere.kotlin.js.dsl.types.reference.JsReference

abstract class JsFunctionRefCommons(
    name: String? = null,
) : JsObjectRef(name ?: "function_${JsReference.nextRefInt()}") {
    override fun toString(): String = present()
}
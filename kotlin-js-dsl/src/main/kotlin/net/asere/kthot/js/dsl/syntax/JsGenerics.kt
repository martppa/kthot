package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.reference.JsReference
import net.asere.kthot.js.dsl.type.value.JsValue

interface JsGenerics : JsReference<JsValue> {
    companion object {
        fun <T : JsValue> syntax(block: JsScope.() -> T): T {
            val scope = JsSyntaxScope()
            return scope.block()
        }

        fun syntax(value: JsElement): JsGenerics = JsGenericsSyntax(value)

        fun syntax(value: String): JsGenerics = syntax(JsSyntax(value))
    }
}

private class JsGenericsSyntax(value: JsElement) : JsGenerics {
    override val _name_: String = "$value"
    override fun present(): String = toString()
    override fun toString(): String = _name_
}

fun <T : JsValue> ((JsElement) -> T).syntax(block: JsScope.() -> T): T {
    val scope = JsSyntaxScope()
    scope.block()
    return this(scope)
}

fun <T : JsValue> ((JsElement) -> T).syntax(value: String): T = this(JsSyntax(value))


package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.declaration.DeclarationType
import net.asere.kotlin.js.dsl.declaration.JsConstantDeclaration
import net.asere.kotlin.js.dsl.declaration.JsMutableDeclaration
import net.asere.kotlin.js.dsl.declaration.Mutable
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.toLine
import net.asere.kotlin.js.dsl.toSyntax
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.JsBooleanValue
import net.asere.kotlin.js.dsl.value.JsNumberValue
import net.asere.kotlin.js.dsl.value.JsStringValue
import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsScriptScope {

    protected abstract fun append(syntax: JsSyntax)

    operator fun JsElement.unaryPlus() = append(toLine())

    operator fun JsValueRef<*>.unaryPlus() = append(toLine())

    operator fun String.unaryPlus() = append(JsLine(this))

    operator fun <T : JsReference<*>> JsSyntaxBuilder<T>.unaryPlus(): T {
        this@JsScriptScope.append(toLine())
        return value
    }

    operator fun JsFunction.unaryPlus(): JsFunctionRef {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toSyntax())
        return builder.value
    }

    operator fun <T : JsFunctionRefCommons> JsFunctionCommons<T>.unaryPlus(): T {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toLine())
        return builder.value
    }

    fun <T : JsDeclarableReference<*>> T.declare(type: DeclarationType): JsSyntaxBuilder<T> {
        val syntax = when (type) {
            Constant -> JsConstantDeclaration(this)
            Mutable -> JsMutableDeclaration(this)
        }
        val builder = JsSyntaxBuilder(this)
        builder.append(syntax)
        return builder
    }

    fun <T : JsReference<*>> T.assign(element: JsElement): JsSyntaxBuilder<T> {
        val builder = JsSyntaxBuilder(this)
        builder.append(JsSyntax("$this = $element"))
        return builder
    }

    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(element: JsElement): JsSyntaxBuilder<T> {
        append(JsSyntax(" = $element"))
        return this
    }

    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: String) = assign(element = value.js)
    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: Number) = assign(element = value.js)
    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: Boolean) = assign(element = value.js)
}

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}
package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.callable.*
import net.asere.kotlin.js.dsl.declaration.*
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.syntax.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.syntax.value.JsObjectSyntax
import net.asere.kotlin.js.dsl.toLine
import net.asere.kotlin.js.dsl.toSyntax
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.JsValue

abstract class JsScriptScope {

    abstract fun append(syntax: JsSyntax)

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
            Const -> JsConstantDeclaration(this)
            Let -> JsLetDeclaration(this)
            Var -> JsVarDeclaration(this)
        }
        val builder = JsSyntaxBuilder(this)
        builder.append(syntax)
        return builder
    }

    fun <T : JsReference<*>> T.assign(element: JsElement): JsSyntaxBuilder<T> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsSyntaxBuilder(this).apply { append(assignOperation) }
    }

    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(element: JsElement): JsSyntaxBuilder<T> {
        val assignOperation = AssignmentOperation(this.toOperable(), element.toOperable())
        return JsSyntaxBuilder(value).apply { append(assignOperation) }
    }

    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: String) = assign(element = value.js)
    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: Number) = assign(element = value.js)
    fun <T : JsReference<*>> JsSyntaxBuilder<T>.assign(value: Boolean) = assign(element = value.js)

    private fun <T : JsReference<C>, C : JsValue> JsSyntaxBuilder<T>.render(): T {
        this@JsScriptScope.append(toLine())
        return value
    }

    infix fun <T : JsReference<C>, C : JsValue> JsSyntaxBuilder<T>.`=`(
        value: Boolean
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<C>, C : JsValue> JsSyntaxBuilder<T>.`=`(
        value: Number
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<C>, C : JsValue> JsSyntaxBuilder<T>.`=`(
        value: String
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<C>, C : JsValue> JsSyntaxBuilder<T>.`=`(
        value: JsElement
    ): T = assign(element = value).render()
}

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}
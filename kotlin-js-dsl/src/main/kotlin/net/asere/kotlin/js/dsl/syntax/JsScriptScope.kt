package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.callable.JsFunction0
import net.asere.kotlin.js.dsl.callable.JsFunctionCommons
import net.asere.kotlin.js.dsl.callable.JsLambdaCommons
import net.asere.kotlin.js.dsl.declaration.*
import net.asere.kotlin.js.dsl.reference.*
import net.asere.kotlin.js.dsl.syntax.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.syntax.operation.Operation
import net.asere.kotlin.js.dsl.toLine
import net.asere.kotlin.js.dsl.toSyntax
import net.asere.kotlin.js.dsl.type.js
import net.asere.kotlin.js.dsl.value.JsValue
import java.util.*

abstract class JsScriptScope {

    private val stack = Stack<JsSyntax>()

    open fun append(syntax: JsSyntax) {
        stack.push(syntax)
    }

    operator fun JsElement.unaryPlus() = append(toLine())

    private fun appendLine(syntax: JsSyntax) {
        append(syntax.toLine())
        stack.clear()
    }

    operator fun <T : JsValue> JsResultSyntax<T>.unaryPlus(): T {
        appendLine(this)
        return innerObject
    }

    operator fun <T : JsLambdaCommons> JsLambdaSyntax<T>.unaryPlus(): T {
        appendLine(this)
        return innerObject
    }

    operator fun JsValueRef<*>.unaryPlus() = append(toLine())

    operator fun String.unaryPlus() = append(JsLine(this))

    operator fun <T : JsReference<*>> JsSyntaxBuilder<T>.unaryPlus(): T {
        this@JsScriptScope.append(toLine())
        return innerObject
    }

    operator fun JsFunction0.unaryPlus(): JsFunction0Ref {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toSyntax())
        return builder.innerObject
    }

    operator fun <T : JsFunctionRefCommons> JsFunctionCommons<T>.unaryPlus(): T {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toLine())
        return builder.innerObject
    }

    fun <T : JsReference<*>> T.declare(type: DeclarationType): JsDeclarationSyntax<T> {
        val syntax = when (type) {
            Const -> JsConstantDeclaration(this)
            Let -> JsLetDeclaration(this)
            Var -> JsVarDeclaration(this)
        }
        return JsDeclarationSyntax(
            innerObject = this,
            syntax = syntax
        )
    }

    fun <T : JsReference<*>> T.assign(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsAssignationSyntax(this, assignOperation)
    }

    fun <T : JsReference<*>> JsResultSyntax<T>.assign(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this.toOperable(), element.toOperable())
        return JsAssignationSyntax(innerObject, assignOperation)
    }

    fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: String) = assign(element = value.js)
    fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: Number) = assign(element = value.js)
    fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: Boolean) = assign(element = value.js)

    private fun <T : JsReference<*>> JsAssignationSyntax<T>.render(): T {
        this@JsScriptScope.append(toLine())
        return innerObject
    }

    infix fun <T : JsReference<*>> JsResultSyntax<T>.`=`(
        value: Boolean
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<*>> JsResultSyntax<T>.`=`(
        value: Number
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<*>> JsResultSyntax<T>.`=`(
        value: String
    ): T = assign(element = value.js).render()

    infix fun <T : JsReference<*>> JsResultSyntax<T>.`=`(
        value: JsElement
    ): T = assign(element = value).render()

    infix fun <T : JsReference<*>> JsResultSyntax<T>.`=`(
        value: Operation
    ): T = assign(element = value).render()
}

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}
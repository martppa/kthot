package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.JsElement
import net.asere.kotlin.js.dsl.declaration.*
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.syntax.operational.Operation
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.toLine
import net.asere.kotlin.js.dsl.toSyntax
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.reference.JsValueRef
import net.asere.kotlin.js.dsl.type.function.JsFunctionRefCommons
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRefCommons
import net.asere.kotlin.js.dsl.type.function.JsFunctionCommons
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.function.f0.JsFunction0
import net.asere.kotlin.js.dsl.type.function.f0.JsFunctionRef
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.value.JsValue
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValueCommons

abstract class JsScriptScope {

    abstract fun append(syntax: JsSyntax)

    operator fun JsElement.unaryPlus() = append(toLine())

    private fun appendLine(syntax: JsSyntax) {
        append(syntax.toLine())
    }

    operator fun <T : JsValue> JsResultSyntax<T>.unaryPlus(): T {
        appendLine(this)
        return innerObject
    }

    operator fun <Reference : JsLambdaRefCommons<Reference>, Lambda : JsLambdaValueCommons> JsLambdaSyntax<Reference, Lambda>.unaryPlus(): Reference {
        appendLine(this)
        return innerObject
    }

    operator fun JsValueRef<*>.unaryPlus() = append(toLine())

    operator fun String.unaryPlus() = append(JsLine(this))

    operator fun <T : JsReference<*>> JsSyntaxBuilder<T>.unaryPlus(): T {
        this@JsScriptScope.append(toLine())
        return innerObject
    }

    operator fun JsFunction0.unaryPlus(): JsFunctionRef {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toSyntax())
        return builder.innerObject
    }

    operator fun <T : JsFunctionRefCommons> JsFunctionCommons<T>.unaryPlus(): T {
        val builder = buildSyntax()
        this@JsScriptScope.append(builder.toLine())
        return builder.innerObject
    }

    fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> T.declare(type: DeclarationType): JsDeclarationSyntax<C> {
        val syntax = when (type) {
            Const -> JsConstantDeclaration(this.reference)
            Let -> JsLetDeclaration(this.reference)
            Var -> JsVarDeclaration(this.reference)
        }
        return JsDeclarationSyntax(
            innerObject = this.reference,
            syntax = syntax
        )
    }

    @JsDsl infix fun <T : JsReference<*>> T.assign(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsAssignationSyntax(this, assignOperation)
    }

    @JsDsl infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this.toOperable(), element.toOperable())
        return JsAssignationSyntax(innerObject, assignOperation)
    }

     @JsDsl infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: String) = assign(element = value.js)
     @JsDsl infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: Number) = assign(element = value.js)
     @JsDsl infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(value: Boolean) = assign(element = value.js)

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
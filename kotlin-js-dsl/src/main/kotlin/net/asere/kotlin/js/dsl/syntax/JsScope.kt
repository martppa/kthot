package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.declaration.DeclarationType
import net.asere.kotlin.js.dsl.declaration.JsConstantDeclaration
import net.asere.kotlin.js.dsl.declaration.JsLetDeclaration
import net.asere.kotlin.js.dsl.declaration.JsVarDeclaration
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.bool.js
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.function.JsFunctionCommons
import net.asere.kotlin.js.dsl.type.function.JsFunctionRefCommons
import net.asere.kotlin.js.dsl.type.function.f0.JsFunction0
import net.asere.kotlin.js.dsl.type.function.f0.JsFunctionRef
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRefCommons
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValueCommons
import net.asere.kotlin.js.dsl.type.number.js
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.string.js
import net.asere.kotlin.js.dsl.type.toLine
import net.asere.kotlin.js.dsl.type.toSyntax
import net.asere.kotlin.js.dsl.type.value.JsValue

abstract class JsScope {

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

    operator fun <T : JsReference<C>, C : JsValue> JsDefinition<T, C>.unaryPlus() {
        appendLine(this.reference.toSyntax())
    }

    operator fun String.unaryPlus() = append(JsLine(this))

    operator fun <T : JsReference<*>> JsSyntaxBuilder<T>.unaryPlus(): T {
        this@JsScope.append(toLine())
        return innerObject
    }

    operator fun JsFunction0.unaryPlus(): JsFunctionRef {
        val builder = buildSyntax()
        this@JsScope.append(builder.toSyntax())
        return builder.innerObject
    }

    operator fun <T : JsFunctionRefCommons> JsFunctionCommons<T>.unaryPlus(): T {
        val builder = buildSyntax()
        this@JsScope.append(builder.toLine())
        return builder.innerObject
    }

    fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> T.declare(type: DeclarationType): JsDeclarationSyntax<C> {
        val syntax = when (type) {
            DeclarationType.Const -> JsConstantDeclaration(this.reference)
            DeclarationType.Let -> JsLetDeclaration(this.reference)
            DeclarationType.Var -> JsVarDeclaration(this.reference)
        }
        return JsDeclarationSyntax(
            innerObject = this.reference,
            syntax = syntax
        )
    }

    fun <T : JsReference<*>> T.assignValue(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsAssignationSyntax(this, assignOperation)
    }

    fun <T : JsReference<*>> JsResultSyntax<T>.assignValue(element: JsElement): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this.toOperable(), element.toOperable())
        return JsAssignationSyntax(innerObject, assignOperation)
    }

    fun JsElement.assignValue(element: JsElement): AssignmentOperation = AssignmentOperation(
        leftHand = this.toOperable(),
        rightHand = element.toOperable()
    )

    fun <T : JsReference<*>> T.assignValue(value: String) = assignValue(element = value.js)
    fun <T : JsReference<*>> T.assignValue(value: Number) = assignValue(element = value.js)
    fun <T : JsReference<*>> T.assignValue(value: Boolean) = assignValue(element = value.js)

    fun <T : JsReference<*>> JsResultSyntax<T>.assignValue(value: String) = assignValue(element = value.js)
    fun <T : JsReference<*>> JsResultSyntax<T>.assignValue(value: Number) = assignValue(element = value.js)
    fun <T : JsReference<*>> JsResultSyntax<T>.assignValue(value: Boolean) = assignValue(element = value.js)

    private fun <T : JsReference<*>> JsAssignationSyntax<T>.render(): T {
        this@JsScope.append(toLine())
        return innerObject
    }

    private fun <T : JsElement> T.render(): T {
        this@JsScope.append(toLine())
        return this
    }

    @JsDsl
    infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(
        value: Boolean
    ): T = assignValue(element = value.js).render()

    @JsDsl
    infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(
        value: Number
    ): T = assignValue(element = value.js).render()

    @JsDsl
    infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(
        value: String
    ): T = assignValue(element = value.js).render()

    @JsDsl
    infix fun <T : JsReference<*>> JsResultSyntax<T>.assign(
        value: JsElement
    ): T = assignValue(element = value).render()

    @JsDsl
    infix fun JsElement.assign(
        value: JsElement
    ): AssignmentOperation = assignValue(element = value).render()
}

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}
@file:Suppress("UNCHECKED_CAST")

package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.declaration.DeclarationType
import net.asere.kotlin.js.dsl.declaration.JsConstantDeclaration
import net.asere.kotlin.js.dsl.declaration.JsLetDeclaration
import net.asere.kotlin.js.dsl.declaration.JsVarDeclaration
import net.asere.kotlin.js.dsl.syntax.operational.access.operation.AssignmentOperation
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.definition.validation.isValidVariableName
import net.asere.kotlin.js.dsl.type.function.JsFunction
import net.asere.kotlin.js.dsl.type.function.JsFunctionRef
import net.asere.kotlin.js.dsl.type.function.f0.JsFunction0
import net.asere.kotlin.js.dsl.type.function.f0.JsFunction0Ref
import net.asere.kotlin.js.dsl.type.reference.JsReference
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

    operator fun <T : JsReference<C>, C : JsValue> JsDefinition<T, C>.unaryPlus() {
        appendLine(this.reference.toSyntax())
    }

    operator fun String.unaryPlus() = append(JsLine(this))

    operator fun Unit.unaryPlus() = append(JsEmptySyntax)

    operator fun <T : JsReference<*>> JsSyntaxBuilder<T>.unaryPlus(): T {
        this@JsScope.append(toLine())
        return innerObject
    }

    operator fun JsFunction0.unaryPlus(): JsFunction0Ref {
        val builder = buildSyntax()
        this@JsScope.append(builder.toLine())
        return builder.innerObject
    }

    operator fun <T : JsFunctionRef> JsFunction<T>.unaryPlus(): T {
        val builder = buildSyntax()
        this@JsScope.append(builder.toLine())
        return builder.innerObject
    }

    fun <T : JsDefinition<C, Q>, C : JsReference<Q>, Q : JsValue> T.declare(type: DeclarationType): JsDeclarationSyntax<C> {
        if (!isValidVariableName("$this"))
            throw IllegalArgumentException("The definition name '$this' is not an allowed JavaScript variable name. Please choose a proper one.")
        val syntax = when (type) {
            DeclarationType.CONST -> JsConstantDeclaration(this.reference)
            DeclarationType.LET -> JsLetDeclaration(this.reference)
            DeclarationType.VAR -> JsVarDeclaration(this.reference)
        }
        return JsDeclarationSyntax(
            innerObject = this.reference,
            syntax = syntax
        )
    }

    fun <T : JsReference<C>, C : JsValue> T.assignValue(element: C): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsAssignationSyntax(this, assignOperation)
    }

    fun <T : JsReference<C>, C : JsValue> JsDeclarationSyntax<T>.assignValue(element: C): JsAssignationSyntax<T> {
        val assignOperation = AssignmentOperation(this.toOperable(), element.toOperable())
        return JsAssignationSyntax(innerObject, assignOperation)
    }

    private fun <T : JsReference<C>, C : JsValue> JsAssignationSyntax<T>.render(): T {
        this@JsScope.append(toLine())
        return innerObject
    }

    @JsDsl
    infix fun <T : JsReference<C>, C : JsValue> T.assign(
        value: C
    ): T = assignValue(element = value).render()

    @JsDsl
    infix fun <T : JsReference<C>, C : JsValue> JsDeclarationSyntax<T>.assign(
        value: C
    ): T = assignValue(element = value).render()
}
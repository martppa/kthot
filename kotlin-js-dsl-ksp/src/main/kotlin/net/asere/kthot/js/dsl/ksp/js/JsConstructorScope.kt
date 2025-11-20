package net.asere.kthot.js.dsl.ksp.js

import net.asere.kthot.js.dsl.syntax.JsAssignationSyntax
import net.asere.kthot.js.dsl.syntax.JsSyntaxScope
import net.asere.kthot.js.dsl.syntax.operational.access.operation.AssignmentOperation
import net.asere.kthot.js.dsl.syntax.toOperable
import net.asere.kthot.js.dsl.tag.JsDsl
import net.asere.kthot.js.dsl.type.toLine
import net.asere.kthot.js.dsl.type.value.JsValue

class JsConstructorScope : JsSyntaxScope() {

    fun JsValue.assignValue(element: JsValue): JsAssignationSyntax<JsValue> {
        val assignOperation = AssignmentOperation(this, element.toOperable())
        return JsAssignationSyntax(this, assignOperation)
    }

    @JsDsl
    infix fun JsValue.assign(
        value: JsValue
    ): JsValue = assignValue(element = value).render()

    private fun JsAssignationSyntax<JsValue>.render(): JsValue {
        this@JsConstructorScope.append(toLine())
        return innerObject
    }
}
package net.asere.kotlin.js.dsl.syntax.loop.jsfor

import net.asere.kotlin.js.dsl.declaration.Constant
import net.asere.kotlin.js.dsl.declaration.Mutable
import net.asere.kotlin.js.dsl.reference.JsDeclarableReference
import net.asere.kotlin.js.dsl.reference.ref
import net.asere.kotlin.js.dsl.syntax.JsSyntax
import net.asere.kotlin.js.dsl.syntax.JsSyntaxBuilder
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.operation.Operable
import net.asere.kotlin.js.dsl.syntax.operation.Operation
import net.asere.kotlin.js.dsl.type.JsCollection
import net.asere.kotlin.js.dsl.type.JsNumber
import net.asere.kotlin.js.dsl.value.JsValue

val forI  = JsNumber.ref("i")
val forJ  = JsNumber.ref("j")
val forK  = JsNumber.ref("k")
val forL  = JsNumber.ref("l")

fun <T : JsValue> jsFor(
    reference: JsDeclarableReference<T>,
    initialValue: T,
    comparable: Operable,
    operation: Operation,
    block: JsSyntaxScope.() -> Unit,
): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsSyntax(
                """for (${JsSyntaxScope().run { 
                    reference.declare(Mutable).assign(initialValue) 
                }}; $comparable; $operation) {
                    $scope
                }""".trimIndent()
            )
        )
    }
}

fun jsFor(
    reference: JsDeclarableReference<*>,
    obj: JsValue,
    block: JsSyntaxScope.() -> Unit,
): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsSyntax(
                """for (${JsSyntaxScope().run { reference.declare(Constant) }} in $obj) {
                    $scope
                }""".trimIndent()
            )
        )
    }
}

fun jsFor(
    reference: JsDeclarableReference<*>,
    collection: JsCollection<*>,
    block: JsSyntaxScope.() -> Unit,
): JsSyntaxBuilder<Unit> {
    val scope = JsSyntaxScope()
    block(scope)
    return JsSyntaxBuilder(Unit).apply {
        append(
            JsSyntax(
                """for (${JsSyntaxScope().run { reference.declare(Constant) }} iof $collection) {
                    $scope
                }""".trimIndent()
            )
        )
    }
}
package net.asere.kthot.js.dsl.syntax

import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.lambda.l0.JsLambda0
import net.asere.kthot.js.dsl.type.lambda.l0.syntax
import net.asere.kthot.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.JsResultLambda1
import net.asere.kthot.js.dsl.type.lambda.l1.syntax
import net.asere.kthot.js.dsl.type.lambda.l2.JsLambda2
import net.asere.kthot.js.dsl.type.lambda.l2.syntax
import net.asere.kthot.js.dsl.type.toSyntax
import net.asere.kthot.js.dsl.type.value.JsValue

fun js(block: JsSyntaxScope.() -> Unit): JsSyntax {
    val scope = JsSyntaxScope()
    block(scope)
    return scope.toSyntax()
}

val (JsScope.() -> Unit).js get(): JsLambda0 {
    val scope = JsSyntaxScope()
    this(scope)
    return JsLambda0.syntax("() => {\n$scope\n}")
}

fun <T : JsValue> (JsScope.(T) -> Unit).js(typeBuilder: (JsElement) -> T): JsLambda1<T> {
    val scope = JsSyntaxScope()
    val param: T = typeBuilder(JsSyntax("value"))
    this(scope, param)
    return JsLambda1.syntax("($param) => {\n$scope\n}")
}

val <reified T : JsValue> (JsScope.(T) -> Unit).js inline get(): JsLambda1<T> {
    val scope = JsSyntaxScope()
    val param: T = provide(JsSyntax("value"))
    this(scope, param)
    return JsLambda1.syntax("($param) => {\n$scope\n}")
}

val <reified Input : JsValue, reified Output : JsValue> (JsScope.(Input) -> Output).js inline get(): JsResultLambda1<Input, Output> {
    val scope = JsSyntaxScope()
    val param: Input = provide(JsSyntax("value"))
    this(scope, param)
    return JsResultLambda1.syntax("($param) => {\n$scope\n}")
}

fun <T : JsValue, C : JsValue> (JsScope.(T, C) -> Unit).js(
    param1Name: String = "value1",
    param2Name: String = "value2",
    tBuilder: (JsElement) -> T,
    cBuilder: (JsElement) -> C
): JsLambda2<T, C> {
    val scope = JsSyntaxScope()
    val param1: T = tBuilder(JsSyntax(param1Name))
    val param2: C = cBuilder(JsSyntax(param2Name))
    this(scope, param1, param2)
    return JsLambda2.syntax("($param1, $param2) => {\n$scope\n}")
}
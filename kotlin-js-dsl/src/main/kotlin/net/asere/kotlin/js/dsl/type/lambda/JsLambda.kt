package net.asere.kotlin.js.dsl.type.lambda

import net.asere.kotlin.js.dsl.JsNothing
import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
import net.asere.kotlin.js.dsl.tag.JsDsl
import net.asere.kotlin.js.dsl.type.JsElement
import net.asere.kotlin.js.dsl.type.definition.JsDefinition
import net.asere.kotlin.js.dsl.type.lambda.l0.JsLambda0Value
import net.asere.kotlin.js.dsl.type.lambda.l0.JsResultLambda0
import net.asere.kotlin.js.dsl.type.lambda.l0.JsResultLambda0Value
import net.asere.kotlin.js.dsl.type.lambda.l0.syntax
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1Value
import net.asere.kotlin.js.dsl.type.lambda.l1.JsResultLambda1
import net.asere.kotlin.js.dsl.type.lambda.l1.JsResultLambda1Value
import net.asere.kotlin.js.dsl.type.lambda.l1.syntax
import net.asere.kotlin.js.dsl.type.lambda.l2.JsLambda2Value
import net.asere.kotlin.js.dsl.type.lambda.l2.JsResultLambda2
import net.asere.kotlin.js.dsl.type.lambda.l2.JsResultLambda2Value
import net.asere.kotlin.js.dsl.type.lambda.l2.syntax
import net.asere.kotlin.js.dsl.type.lambda.l3.JsLambda3
import net.asere.kotlin.js.dsl.type.lambda.l3.JsLambda3Value
import net.asere.kotlin.js.dsl.type.lambda.l3.JsResultLambda3
import net.asere.kotlin.js.dsl.type.lambda.l3.JsResultLambda3Value
import net.asere.kotlin.js.dsl.type.lambda.l3.syntax
import net.asere.kotlin.js.dsl.type.lambda.l4.JsLambda4
import net.asere.kotlin.js.dsl.type.lambda.l4.JsLambda4Value
import net.asere.kotlin.js.dsl.type.lambda.l4.JsResultLambda4
import net.asere.kotlin.js.dsl.type.lambda.l4.JsResultLambda4Value
import net.asere.kotlin.js.dsl.type.lambda.l4.syntax
import net.asere.kotlin.js.dsl.type.lambda.l5.JsLambda5
import net.asere.kotlin.js.dsl.type.lambda.l5.JsLambda5Value
import net.asere.kotlin.js.dsl.type.lambda.l5.JsResultLambda5
import net.asere.kotlin.js.dsl.type.lambda.l5.JsResultLambda5Value
import net.asere.kotlin.js.dsl.type.lambda.l5.syntax
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

fun jsAsyncLambda(definition: JsScope.() -> Unit): JsResultLambda0<JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda {
            definition(this)
        }
    }
    return JsResultLambda0.syntax<JsPromise<JsNothing>>(JsAsyncSyntax(value = value), isNullable = false)
}

inline fun <reified Result : JsValue> jsAsyncResultLambda(
    crossinline definition: JsScope.() -> Result
): JsResultLambda0<JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda {
            definition(this)
        }
    }
    return JsResultLambda0.syntax<JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable ->
            JsPromise.syntax(element, isNullable)
        },
        isNullable = false
    )
}

fun <Param1Ref : JsReference<Param1>, Param1 : JsValue> jsAsyncLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsScope.() -> Unit
): JsResultLambda1<Param1, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda(param1 = param1) {
            definition(this)
        }
    }
    return JsResultLambda1.syntax<Param1, JsPromise<JsNothing>>(JsAsyncSyntax(value = value), isNullable = false)
}

inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, reified Result : JsValue> jsAsyncResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    crossinline definition: JsScope.(Param1Ref) -> Result
): JsResultLambda1<Param1, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda(param1 = param1) {
            definition(this, it)
        }
    }
    return JsResultLambda1.syntax<Param1, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue> jsAsyncLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsScope.(Param1Ref, Param2Ref) -> Unit
): JsResultLambda2<Param1, Param2, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda(param1 = param1, param2 = param2) { p1, p2 ->
            definition(this, p1, p2)
        }
    }
    return JsResultLambda2.syntax<Param1, Param2, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, reified Result : JsValue> jsAsyncResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    crossinline definition: JsScope.(Param1Ref, Param2Ref) -> Result
): JsResultLambda2<Param1, Param2, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda(param1 = param1, param2 = param2) { p1, p2 ->
            definition(this, p1, p2)
        }
    }
    return JsResultLambda2.syntax<Param1, Param2, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue
        > jsAsyncLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    definition: JsScope.(Param1Ref, Param2Ref, Param3Ref) -> Unit
): JsResultLambda3<Param1, Param2, Param3, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda(param1 = param1, param2 = param2, param3 = param3) { p1, p2, p3 ->
            definition(this, p1, p2, p3)
        }
    }
    return JsResultLambda3.syntax<Param1, Param2, Param3, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        reified Result : JsValue
        > jsAsyncResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    crossinline definition: JsScope.(Param1Ref, Param2Ref, Param3Ref) -> Result
): JsResultLambda3<Param1, Param2, Param3, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda(param1 = param1, param2 = param2, param3 = param3) { p1, p2, p3 ->
            definition(this, p1, p2, p3)
        }
    }
    return JsResultLambda3.syntax<Param1, Param2, Param3, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue
        > jsAsyncLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    definition: JsScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref) -> Unit
): JsResultLambda4<Param1, Param2, Param3, Param4, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda(param1 = param1, param2 = param2, param3 = param3, param4 = param4) { p1, p2, p3, p4 ->
            definition(this, p1, p2, p3, p4)
        }
    }
    return JsResultLambda4.syntax<Param1, Param2, Param3, Param4, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        reified Result : JsValue
        > jsAsyncResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    crossinline definition: JsScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref) -> Result
): JsResultLambda4<Param1, Param2, Param3, Param4, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda(param1 = param1, param2 = param2, param3 = param3, param4 = param4) { p1, p2, p3, p4 ->
            definition(this, p1, p2, p3, p4)
        }
    }
    return JsResultLambda4.syntax<Param1, Param2, Param3, Param4, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        Param5Ref : JsReference<Param5>, Param5 : JsValue
        > jsAsyncLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    definition: JsScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref, Param5Ref) -> Unit
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda(
            param1 = param1,
            param2 = param2,
            param3 = param3,
            param4 = param4,
            param5 = param5
        ) { p1, p2, p3, p4, p5 ->
            definition(this, p1, p2, p3, p4, p5)
        }
    }
    return JsResultLambda5.syntax<Param1, Param2, Param3, Param4, Param5, JsPromise<JsNothing>>(
        value = JsAsyncSyntax(value = value),
        isNullable = false
    )
}

inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        Param5Ref : JsReference<Param5>, Param5 : JsValue,
        reified Result : JsValue
        > jsAsyncResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    crossinline definition: JsScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref, Param5Ref) -> Result
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsResultLambda(
            param1 = param1,
            param2 = param2,
            param3 = param3,
            param4 = param4,
            param5 = param5
        ) { p1, p2, p3, p4, p5 ->
            definition(this, p1, p2, p3, p4, p5)
        }
    }
    return JsResultLambda5.syntax<Param1, Param2, Param3, Param4, Param5, JsPromise<Result>>(
        value = JsAsyncSyntax(value = value),
        resultTypeBuilder = { element, isNullable -> JsPromise.syntax(element, isNullable) },
        isNullable = false
    )
}

fun jsLambda(
    definition: JsSyntaxScope.() -> Unit,
): JsLambda0Value = JsLambda0Value(
    definition = definition
)

@OptIn(InternalApi::class)
fun <Result : JsValue> jsResultLambda(
    definition: JsSyntaxScope.() -> Result,
): JsResultLambda0Value<Result> = JsResultLambda0Value(
    definition = definition
)

fun <Param1Ref : JsReference<Param1>, Param1 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(Param1Ref) -> Unit,
): JsLambda1Value<Param1Ref, Param1> = JsLambda1Value(
    param = param1,
    definition = definition
)

@OptIn(InternalApi::class)
inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, reified Result : JsValue> jsResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    noinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1Ref) -> Result,
): JsResultLambda1Value<Param1Ref, Param1, Result> = JsResultLambda1Value(
    param = param1,
    resultTypeBuilder = resultTypeBuilder,
    definition = definition
)

fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Unit,
): JsLambda2Value<Param1Ref, Param1, Param2Ref, Param2> = JsLambda2Value(
    param1 = param1,
    param2 = param2,
    definition = definition
)

@OptIn(InternalApi::class)
inline fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue, reified Result : JsValue> jsResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    noinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Result,
): JsResultLambda2<Param1, Param2, Result> = JsResultLambda2Value(
    param1 = param1,
    param2 = param2,
    resultTypeBuilder = resultTypeBuilder,
    definition = definition
)

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref) -> Unit,
): JsLambda3<Param1, Param2, Param3> = JsLambda3Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    definition = definition
)

@OptIn(InternalApi::class)
inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        reified Result : JsValue> jsResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    noinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref) -> Result,
): JsResultLambda3<Param1, Param2, Param3, Result> = JsResultLambda3Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    resultTypeBuilder = resultTypeBuilder,
    definition = definition
)

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref) -> Unit,
): JsLambda4<Param1, Param2, Param3, Param4> = JsLambda4Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    definition = definition
)

@OptIn(InternalApi::class)
inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        reified Result : JsValue> jsResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    noinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref) -> Result,
): JsResultLambda4<Param1, Param2, Param3, Param4, Result> = JsResultLambda4Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    resultTypeBuilder = resultTypeBuilder,
    definition = definition
)

fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        Param5Ref : JsReference<Param5>, Param5 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref, Param5Ref) -> Unit,
): JsLambda5<Param1, Param2, Param3, Param4, Param5> = JsLambda5Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    definition = definition
)

@OptIn(InternalApi::class)
inline fun <
        Param1Ref : JsReference<Param1>, Param1 : JsValue,
        Param2Ref : JsReference<Param2>, Param2 : JsValue,
        Param3Ref : JsReference<Param3>, Param3 : JsValue,
        Param4Ref : JsReference<Param4>, Param4 : JsValue,
        Param5Ref : JsReference<Param5>, Param5 : JsValue,
        reified Result : JsValue> jsResultLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    param3: JsDefinition<Param3Ref, Param3>,
    param4: JsDefinition<Param4Ref, Param4>,
    param5: JsDefinition<Param5Ref, Param5>,
    noinline resultTypeBuilder: (JsElement, Boolean) -> Result = ::provide,
    noinline definition: JsSyntaxScope.(Param1Ref, Param2Ref, Param3Ref, Param4Ref, Param5Ref) -> Result,
): JsResultLambda5<Param1, Param2, Param3, Param4, Param5, Result> = JsResultLambda5Value(
    param1 = param1,
    param2 = param2,
    param3 = param3,
    param4 = param4,
    param5 = param5,
    resultTypeBuilder = resultTypeBuilder,
    definition = definition
)
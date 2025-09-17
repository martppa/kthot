package net.asere.kotlin.js.dsl.type.lambda

import net.asere.kotlin.js.dsl.JsNothing
import net.asere.kotlin.js.dsl.annotation.InternalApi
import net.asere.kotlin.js.dsl.provider.provide
import net.asere.kotlin.js.dsl.syntax.JsScope
import net.asere.kotlin.js.dsl.syntax.JsSyntaxScope
import net.asere.kotlin.js.dsl.syntax.async.JsAsyncSyntax
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
import net.asere.kotlin.js.dsl.type.lambda.l3.*
import net.asere.kotlin.js.dsl.type.lambda.l4.*
import net.asere.kotlin.js.dsl.type.lambda.l5.*
import net.asere.kotlin.js.dsl.type.promise.JsPromise
import net.asere.kotlin.js.dsl.type.promise.syntax
import net.asere.kotlin.js.dsl.type.reference.JsReference
import net.asere.kotlin.js.dsl.type.value.JsValue

/**
 * Creates an asynchronous lambda with no parameters that returns a [JsPromise] that resolves with no value.
 *
 * @param definition A block containing the body of the lambda.
 * @return A [JsResultLambda0] representing the asynchronous lambda.
 */
fun jsAsyncLambda(definition: JsScope.() -> Unit): JsResultLambda0<JsPromise<JsNothing>> {
    val scope = JsSyntaxScope()
    val value = scope.run {
        jsLambda {
            definition(this)
        }
    }
    return JsResultLambda0.syntax<JsPromise<JsNothing>>(JsAsyncSyntax(value = value), isNullable = false)
}

/**
 * Creates an asynchronous lambda with no parameters that returns a [JsPromise] containing a value of type [Result].
 *
 * @param definition A block containing the body of the lambda that returns a [Result].
 * @return A [JsResultLambda0] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates an asynchronous lambda with one parameter that returns a [JsPromise] that resolves with no value.
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param definition A block containing the body of the lambda.
 * @return A [JsResultLambda1] representing the asynchronous lambda.
 */
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

/**
 * Creates an asynchronous lambda with one parameter that returns a [JsPromise] containing a value of type [Result].
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param definition A block containing the body of the lambda that receives a reference to the parameter and returns a [Result].
 * @return A [JsResultLambda1] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates an asynchronous lambda with two parameters that returns a [JsPromise] that resolves with no value.
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters.
 * @return A [JsResultLambda2] representing the asynchronous lambda.
 */
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

/**
 * Creates an asynchronous lambda with two parameters that returns a [JsPromise] containing a value of type [Result].
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters and returns a [Result].
 * @return A [JsResultLambda2] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates an asynchronous lambda with three parameters that returns a [JsPromise] that resolves with no value.
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters.
 * @return A [JsResultLambda3] representing the asynchronous lambda.
 */
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

/**
 * Creates an asynchronous lambda with three parameters that returns a [JsPromise] containing a value of type [Result].
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters and returns a [Result].
 * @return A [JsResultLambda3] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates an asynchronous lambda with four parameters that returns a [JsPromise] that resolves with no value.
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters.
 * @return A [JsResultLambda4] representing the asynchronous lambda.
 */
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

/**
 * Creates an asynchronous lambda with four parameters that returns a [JsPromise] containing a value of type [Result].
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters and returns a [Result].
 * @return A [JsResultLambda4] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates an asynchronous lambda with five parameters that returns a [JsPromise] that resolves with no value.
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters.
 * @return A [JsResultLambda5] representing the asynchronous lambda.
 */
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

/**
 * Creates an asynchronous lambda with five parameters that returns a [JsPromise] containing a value of type [Result].
 *
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param definition A block containing the body of the lambda that receives references to the parameters and returns a [Result].
 * @return A [JsResultLambda5] representing the asynchronous lambda with a returning value.
 */
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

/**
 * Creates a standard lambda with no parameters.
 * @param definition The body of the lambda.
 * @return A [JsLambda0Value] representing the lambda.
 */
fun jsLambda(
    definition: JsSyntaxScope.() -> Unit,
): JsLambda0Value = JsLambda0Value(
    definition = definition
)

/**
 * Creates a standard lambda with no parameters that returns a value.
 * @param definition The body of the lambda that returns a value of type [Result].
 * @return A [JsResultLambda0Value] representing the lambda.
 */
@OptIn(InternalApi::class)
fun <Result : JsValue> jsResultLambda(
    definition: JsSyntaxScope.() -> Result,
): JsResultLambda0Value<Result> = JsResultLambda0Value(
    definition = definition
)

/**
 * Creates a standard lambda with one parameter.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param definition The body of the lambda that receives a reference to the parameter.
 * @return A [JsLambda1Value] representing the lambda.
 */
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    definition: JsSyntaxScope.(Param1Ref) -> Unit,
): JsLambda1Value<Param1Ref, Param1> = JsLambda1Value(
    param = param1,
    definition = definition
)

/**
 * Creates a standard lambda with one parameter that returns a value.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param resultTypeBuilder A function to build the result type.
 * @param definition The body of the lambda that receives a reference to the parameter and returns a value of type [Result].
 * @return A [JsResultLambda1Value] representing the lambda.
 */
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

/**
 * Creates a standard lambda with two parameters.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param definition The body of the lambda that receives references to the parameters.
 * @return A [JsLambda2Value] representing the lambda.
 */
fun <Param1Ref : JsReference<Param1>, Param1 : JsValue, Param2Ref : JsReference<Param2>, Param2 : JsValue> jsLambda(
    param1: JsDefinition<Param1Ref, Param1>,
    param2: JsDefinition<Param2Ref, Param2>,
    definition: JsSyntaxScope.(Param1Ref, Param2Ref) -> Unit,
): JsLambda2Value<Param1Ref, Param1, Param2Ref, Param2> = JsLambda2Value(
    param1 = param1,
    param2 = param2,
    definition = definition
)

/**
 * Creates a standard lambda with two parameters that returns a value.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param resultTypeBuilder A function to build the result type.
 * @param definition The body of the lambda that receives references to the parameters and returns a value of type [Result].
 * @return A [JsResultLambda2] representing the lambda.
 */
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

/**
 * Creates a standard lambda with three parameters.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param definition The body of the lambda that receives references to the parameters.
 * @return A [JsLambda3] representing the lambda.
 */
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

/**
 * Creates a standard lambda with three parameters that returns a value.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param resultTypeBuilder A function to build the result type.
 * @param definition The body of the lambda that receives references to the parameters and returns a value of type [Result].
 * @return A [JsResultLambda3] representing the lambda.
 */
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

/**
 * Creates a standard lambda with four parameters.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param definition The body of the lambda that receives references to the parameters.
 * @return A [JsLambda4] representing the lambda.
 */
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

/**
 * Creates a standard lambda with four parameters that returns a value.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param resultTypeBuilder A function to build the result type.
 * @param definition The body of the lambda that receives references to the parameters and returns a value of type [Result].
 * @return A [JsResultLambda4] representing the lambda.
 */
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

/**
 * Creates a standard lambda with five parameters.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param definition The body of the lambda that receives references to the parameters.
 * @return A [JsLambda5] representing the lambda.
 */
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

/**
 * Creates a standard lambda with five parameters that returns a value.
 * @param param1 A [JsDefinition] for the first parameter.
 * @param param2 A [JsDefinition] for the second parameter.
 * @param param3 A [JsDefinition] for the third parameter.
 * @param param4 A [JsDefinition] for the fourth parameter.
 * @param param5 A [JsDefinition] for the fifth parameter.
 * @param resultTypeBuilder A function to build the result type.
 * @param definition The body of the lambda that receives references to the parameters and returns a value of type [Result].
 * @return A [JsResultLambda5] representing the lambda.
 */
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
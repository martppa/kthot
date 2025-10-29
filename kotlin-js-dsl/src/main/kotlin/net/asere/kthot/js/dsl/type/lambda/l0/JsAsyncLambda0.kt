package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.JsNothing
import net.asere.kthot.js.dsl.provider.provide
import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.Undefined
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.reference.ReferenceId
import net.asere.kthot.js.dsl.type.value.JsValue

fun JsLambda0.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
): JsResultLambda0<JsPromise<JsNothing>> = JsResultLambda0Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(Undefined)},
)

fun JsLambda0.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
) = object : JsPrintableDefinition<JsResultLambda0Ref<JsPromise<JsNothing>>, JsResultLambda0<JsPromise<JsNothing>>>() {
    override val reference: JsResultLambda0Ref<JsPromise<JsNothing>> = JsResultLambda0Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(element)},
    )
}

inline fun <reified Result : JsValue> JsResultLambda0.Companion.asyncRef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
): JsResultLambda0<JsPromise<Result>> = JsResultLambda0Ref(
    name = name,
    resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element))},
)

inline fun <reified Result : JsValue> JsResultLambda0.Companion.asyncDef(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    noinline resultTypeBuilder: (JsElement) -> Result = ::provide,
) = object : JsPrintableDefinition<JsResultLambda0Ref<JsPromise<Result>>, JsResultLambda0<JsPromise<Result>>>() {
    override val reference: JsResultLambda0Ref<JsPromise<Result>> = JsResultLambda0Ref(
        name = name,
        resultTypeBuilder = { element -> JsPromise.syntax(resultTypeBuilder(element))},
    )
}
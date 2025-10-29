package net.asere.kthot.js.dsl.type.lambda.l0

import net.asere.kthot.js.dsl.type.JsElement
import net.asere.kthot.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kthot.js.dsl.type.lambda.JsLambdaRef
import net.asere.kthot.js.dsl.type.reference.ReferenceId

class JsLambda0Ref internal constructor(
    name: String,
) : JsLambdaRef<JsLambda0>(name), JsLambda0

fun JsLambda0.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
): JsLambda0 = JsLambda0Ref(name)

fun JsLambda0.Companion.ref(
    element: JsElement,
): JsLambda0 = JsLambda0Ref(element.present())

fun JsLambda0.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
) = object : JsPrintableDefinition<JsLambda0Ref, JsLambda0>() {
    override val reference: JsLambda0Ref = JsLambda0Ref(name)
}
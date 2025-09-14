package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef
import net.asere.kotlin.js.dsl.type.reference.ReferenceId

class JsLambda0Ref internal constructor(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRef<JsLambda0>(name, isNullable), JsLambda0

fun JsLambda0.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    isNullable: Boolean = false
): JsLambda0 = JsLambda0Ref(name, isNullable)

fun JsLambda0.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda0Ref, JsLambda0>() {
    override val reference: JsLambda0Ref = JsLambda0Ref(name, isNullable)
}
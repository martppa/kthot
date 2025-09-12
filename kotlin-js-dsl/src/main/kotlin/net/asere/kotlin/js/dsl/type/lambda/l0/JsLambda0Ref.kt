package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.syntax.operational.invocation.operation.InvocationOperation
import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef

class JsLambda0Ref(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRef<JsLambda0>(name, isNullable), JsLambda0 {

    override operator fun invoke(): InvocationOperation = InvocationOperation(this)
}

fun JsLambda0.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    isNullable: Boolean = false
): JsLambda0Ref = JsLambda0Ref(name, isNullable)

fun JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambda0Ref, JsLambda0>() {
    override val reference: JsLambda0Ref = JsLambda0Ref(name, isNullable)
}
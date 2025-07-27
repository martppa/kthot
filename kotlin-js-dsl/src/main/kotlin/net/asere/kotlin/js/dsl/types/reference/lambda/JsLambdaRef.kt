package net.asere.kotlin.js.dsl.types.reference.lambda

import net.asere.kotlin.js.dsl.types.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.types.reference.ReferenceId
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda
import net.asere.kotlin.js.dsl.types.type.lambda.JsLambda1
import net.asere.kotlin.js.dsl.types.value.lambda.JsLambdaValue

fun JsLambdaValue.Companion.ref(name: String = "lambda_${ReferenceId.nextRefInt()}") = JsLambdaRef(name)

class JsLambdaRef(
    name: String,
    isNullable: Boolean = false
) : JsLambdaRefCommons<JsLambda>(name, isNullable), JsLambda

fun JsLambda.Companion.ref(
    name: String = "lambda_${ReferenceId.nextRefInt()}",
    isNullable: Boolean = false
): JsLambdaRef = JsLambdaRef(name, isNullable)

fun JsLambda1.Companion.def(
    name: String = "lambda_${ReferenceId.nextRefInt()}", isNullable: Boolean = false
) = object : JsPrintableDefinition<JsLambdaRef, JsLambda>() {
    override val reference: JsLambdaRef = JsLambdaRef(name, isNullable)
}
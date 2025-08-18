package net.asere.kotlin.js.dsl.type.lambda.l0

import net.asere.kotlin.js.dsl.type.definition.JsPrintableDefinition
import net.asere.kotlin.js.dsl.type.reference.ReferenceId
import net.asere.kotlin.js.dsl.type.lambda.l1.JsLambda1
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRefCommons

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
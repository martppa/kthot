package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.types.value.lambda.JsLambdaValueCommons
import net.asere.kotlin.js.dsl.types.reference.lambda.JsLambdaRefCommons

class JsLambdaSyntax<Reference : JsLambdaRefCommons<Reference>, Lambda : JsLambdaValueCommons>(
    reference: Reference,
    lambda: Lambda
) : JsResultSyntax<Reference>(
    innerObject = reference,
    syntax = JsSyntax("$lambda")
)
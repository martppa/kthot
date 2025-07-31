package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValueCommons
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRefCommons

class JsLambdaSyntax<Reference : JsLambdaRefCommons<Reference>, Lambda : JsLambdaValueCommons>(
    reference: Reference,
    lambda: Lambda
) : JsResultSyntax<Reference>(
    innerObject = reference,
    syntax = JsSyntax("$lambda")
)
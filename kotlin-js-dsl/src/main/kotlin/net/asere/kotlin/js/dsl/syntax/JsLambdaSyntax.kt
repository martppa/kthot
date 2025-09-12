package net.asere.kotlin.js.dsl.syntax

import net.asere.kotlin.js.dsl.type.lambda.JsLambdaValue
import net.asere.kotlin.js.dsl.type.lambda.JsLambdaRef

class JsLambdaSyntax<Reference : JsLambdaRef<Reference>, Lambda : JsLambdaValue>(
    reference: Reference,
    lambda: Lambda
) : JsResultSyntax<Reference>(
    innerObject = reference,
    syntax = JsSyntax("$lambda")
)
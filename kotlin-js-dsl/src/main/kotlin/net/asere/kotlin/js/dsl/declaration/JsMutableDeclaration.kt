package net.asere.kotlin.js.dsl.declaration

import net.asere.kotlin.js.dsl.reference.JsReference

class JsMutableDeclaration(
    jsObject: JsReference<*>,
) : JsDeclaration("let $jsObject")
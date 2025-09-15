package net.asere.kotlin.js.dsl.syntax.operational

import net.asere.kotlin.js.dsl.syntax.group.groupIfGroupable
import net.asere.kotlin.js.dsl.type.JsElement

abstract class ReflexiveOperation : Operation() {

    internal abstract val leftSideElement: JsElement
    internal abstract val rightSideElement: JsElement

    override val value: String get() {
        val stringBuilder = StringBuilder()
        stringBuilder.append("${leftSideElement.groupIfGroupable()}")
        stringBuilder.append("$rightSideElement")
        return stringBuilder.toString()
    }
}
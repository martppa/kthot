package net.asere.kthot.js.dsl.provider

import net.asere.kthot.js.dsl.type.JsElement

open class Beacon(private val builder: (JsElement) -> Any) {
    open operator fun invoke(value: JsElement) = builder(value)
}
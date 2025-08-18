package net.asere.kotlin.js.dsl.provider

open class Beacon(private val builder: () -> Any) {
    open operator fun invoke() = builder()
}
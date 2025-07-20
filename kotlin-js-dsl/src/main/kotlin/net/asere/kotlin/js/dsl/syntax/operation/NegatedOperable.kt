package net.asere.kotlin.js.dsl.syntax.operation

class NegatedOperable<T : Operable>(
    internal val operable: T,
) : Operable {
    override fun present(): String = "!$operable"
    override fun toString() = present()
}
package net.asere.kotlin.js.dsl.syntax.operation

class NegatedOperation<T : Operation>(
    internal val comparison: T,
) : Operation() {
    override fun present(): String = "!($comparison)"
}
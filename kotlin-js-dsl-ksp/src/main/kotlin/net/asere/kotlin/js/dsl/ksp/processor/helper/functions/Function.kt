package net.asere.kotlin.js.dsl.ksp.processor.helper.functions

import com.google.devtools.ksp.symbol.KSType

class Function(
    private val name: String,
    private val arguments: List<Argument> = listOf(),
    private val returnType: KSType,
    private val body: (StringBuilder) -> Unit
) {
}
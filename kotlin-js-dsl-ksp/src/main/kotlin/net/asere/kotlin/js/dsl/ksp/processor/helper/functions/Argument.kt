package net.asere.kotlin.js.dsl.ksp.processor.helper.functions

import com.google.devtools.ksp.symbol.KSType

data class Argument(
    val name: String,
    val type: KSType
)
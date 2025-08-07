package net.asere.kotlin.js.dsl.ksp.model

import com.google.devtools.ksp.symbol.KSType

data class DeclarationItems(
    val genericTypes: List<KSType>,
    val superTypes: List<KSType>,
    val bounds: List<KSType>,
)
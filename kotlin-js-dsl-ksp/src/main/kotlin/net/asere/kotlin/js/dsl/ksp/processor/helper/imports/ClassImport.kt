package net.asere.kotlin.js.dsl.ksp.processor.helper.imports

import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSType
import net.asere.kotlin.js.dsl.ksp.extension.fullName

class ClassImport(declaration: KSDeclaration) : ImportSyntaxBlock {
    constructor(type: KSType) : this(type.declaration)

    override val value: String = declaration.fullName
}
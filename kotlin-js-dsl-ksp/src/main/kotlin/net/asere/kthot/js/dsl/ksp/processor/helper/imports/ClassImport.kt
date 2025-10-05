package net.asere.kthot.js.dsl.ksp.processor.helper.imports

import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSType
import net.asere.kthot.js.dsl.ksp.extension.fullName

class ClassImport(declaration: KSDeclaration) : ImportSyntaxBlock {
    constructor(type: KSType) : this(type.declaration)

    override val value: String = declaration.fullName
}
package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.jsName

class JsApiInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun getImportPath(declaration: KSClassDeclaration): String = "${
        declaration.packageName.asString().replace(".", "/")
    }/${declaration.jsName}.js"
}
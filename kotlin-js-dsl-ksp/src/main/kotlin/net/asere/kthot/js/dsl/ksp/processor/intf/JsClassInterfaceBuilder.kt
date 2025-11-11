package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.fullJsName
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.extension.loadClass
import net.asere.kthot.js.dsl.ksp.extension.name

class JsClassInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun appendImports(
        stringBuilder: StringBuilder,
        declaration: KSClassDeclaration,
        resolver: Resolver
    ): Unit = with(stringBuilder) {
        append("import ${declaration.fullJsName}Module\n")
        super.appendImports(stringBuilder, declaration, resolver)
    }

    override fun appendCompanion(stringBuilder: StringBuilder, resolver: Resolver, declaration: KSClassDeclaration): Unit = with(stringBuilder) {
        append("\n")
        append("   companion object {\n")
        append("       val Module = ${declaration.jsName}Module()\n")
        append("   }\n")
    }

    override fun getImportPath(declaration: KSClassDeclaration): String = "${
        declaration.packageName.asString().replace(".", "/")
    }/${declaration.jsName}.js"
}
package net.asere.kthot.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.CodeGenerator
import com.google.devtools.ksp.processing.KSPLogger
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import net.asere.kthot.js.dsl.ksp.extension.jsName
import net.asere.kthot.js.dsl.ksp.extension.loadClass
import net.asere.kthot.js.dsl.ksp.extension.name
import net.asere.kthot.js.dsl.ksp.processor.jsClassModuleName

class JsClassInterfaceBuilder(
    codeGenerator: CodeGenerator,
    logger: KSPLogger
) : JsInterfaceBuilder(
    codeGenerator, logger
) {
    override fun StringBuilder.appendCompanion(resolver: Resolver, declaration: KSClassDeclaration) {
        val moduleClass = resolver.loadClass(jsClassModuleName)
        append("\n")
        append("   companion object {\n")
        append("       val Module = ${moduleClass.name}(\"${declaration.jsName}\", \"/${
            declaration.packageName.asString().replace(".", "/")
        }/${declaration.jsName}.js\")\n")
        append("   }\n")
    }

    override fun getModuleClass(resolver: Resolver): KSClassDeclaration {
        return resolver.loadClass(jsClassModuleName)
    }

    override fun getImportPath(declaration: KSClassDeclaration): String = "${
        declaration.packageName.asString().replace(".", "/")
    }/${declaration.jsName}.js"
}
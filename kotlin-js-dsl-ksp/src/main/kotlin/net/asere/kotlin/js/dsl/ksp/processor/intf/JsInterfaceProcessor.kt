package net.asere.kotlin.js.dsl.ksp.processor.intf

import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSTypeParameter
import com.google.devtools.ksp.validate
import net.asere.kotlin.js.dsl.ksp.extension.*
import java.io.OutputStreamWriter

class JsInterfaceProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    private val jsClassAnnotationName = "net.asere.kotlin.js.dsl.ksp.annotation.JsClass"
    private val jsChainOperationName = "net.asere.kotlin.js.dsl.syntax.operation.ChainOperation"
    private val jsInvocationOperationName = "net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation"
    private val jsObjectName = "net.asere.kotlin.js.dsl.type.obj.JsObject"
    private val jsSyntaxName = "net.asere.kotlin.js.dsl.syntax.JsSyntax"
    private lateinit var chainOperationDeclaration: KSClassDeclaration
    private lateinit var invocationOperationDeclaration: KSClassDeclaration
    private lateinit var jsObjectDeclaration: KSClassDeclaration
    private lateinit var jsSyntaxDeclaration: KSClassDeclaration

    override fun process(resolver: Resolver): List<KSAnnotated> {

        resolver.checkDependencies()

        val declarations = findDeclarations(resolver) ?: return emptyList()

        for (declaration in declarations) {
            createInterface(declaration, resolver)
        }

        return declarations.filterNot { it.validate() }.toList()
    }

    private fun Resolver.checkDependencies() {
        chainOperationDeclaration = loadClass(jsChainOperationName)
        invocationOperationDeclaration = loadClass(jsInvocationOperationName)
        jsObjectDeclaration = loadClass(jsObjectName)
        jsSyntaxDeclaration = loadClass(jsSyntaxName)
    }

    private fun createInterface(declaration: KSClassDeclaration, resolver: Resolver) {
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        codeBuilder.appendImports(declaration, resolver)
        val interfaceName = codeBuilder.appendDeclaration(declaration)
        codeBuilder.appendProperties(declaration, resolver)
        codeBuilder.appendMethods(declaration, resolver)
        writeToFile(
            fileName = interfaceName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun StringBuilder.appendDeclaration(declaration: KSClassDeclaration): String {
        val jsClassAnnotation = declaration.annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName
        } ?: throw IllegalStateException("@JsClass annotation not found on ${declaration.qualifiedName?.asString()}")

        val interfaceNameFromAnnotation =
            jsClassAnnotation.arguments.find { it.name?.asString() == "name" }?.value as? String
        val interfaceName = if (interfaceNameFromAnnotation.isNullOrBlank()) {
            "Js${declaration.name}"
        } else {
            interfaceNameFromAnnotation
        }

        append("interface ${declaration.getDeclarativeName(interfaceName)} {\n")
        return interfaceName
    }

    private fun StringBuilder.appendImports(declaration: KSClassDeclaration, resolver: Resolver) {
        val imports: MutableSet<String> = mutableSetOf()
        imports.add(chainOperationDeclaration.fullName)
        imports.add(invocationOperationDeclaration.fullName)
        declaration.superTypeInterfaces.forEach { type ->
            imports.add(type.declaration.fullName)
            imports.addAll(type.getBoundsTypes().map { it.declaration.fullName })
        }
        declaration.getJsAvailableProperties(resolver)
            .filter { it.type.resolve().declaration !is KSTypeParameter }
            .forEach { property ->
                imports.add(property.typeFullName)
                if (!property.isTypeSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${property.typePackage}.syntax")
                }
            }
        if (declaration.superTypeInterfaces.isEmpty()) {
            imports.add(jsObjectDeclaration.fullName)
        } else {
            declaration.superTypeInterfaces.forEach {
                imports.add(it.declaration.fullName)
            }
        }
        for (function in declaration.getJsAvailableFunctions(resolver)) {
            logger.warn("" + (function.returnType?.resolve()?.declaration !is KSTypeParameter))
            if (function.returnType?.resolve() !is KSTypeParameter) {
                imports.add(function.returnType!!.resolve().declaration.fullName)
                if (!function.returnType.isSubclassOf(jsSyntaxDeclaration)) {
                    imports.add("${function.returnType!!.packageName}.syntax")
                }
            }
            function.parameters.filter { it.type.resolve() !is KSTypeParameter }.forEach { param ->
                imports.add(param.type.resolve().declaration.fullName)
            }
        }
        declaration.typeParameters
            .map { type -> type.bounds.toList().map { it.resolve().declaration.fullName } }.flatten().forEach {
                imports.add(it)
            }
        imports.remove("kotlin.Any")
        imports.forEach {
            append("import $it\n")
        }
        append("\n")
    }

    private fun StringBuilder.appendProperties(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getJsAvailableProperties(resolver).forEach { property ->
            val propertyName = property.name
            val propertyType = property.typeName
            append("  val $propertyName: $propertyType get() = $propertyType.syntax(${chainOperationDeclaration.name}(this, \"$propertyName\"))\n")
        }
    }

    private fun StringBuilder.appendMethods(declaration: KSClassDeclaration, resolver: Resolver) {
        declaration.getJsAvailableFunctions(resolver).forEach { function ->
            val functionName = function.name
            val returnType = function.returnType?.resolve()?.declaration?.name ?: "Unit"
            append(
                "  fun $functionName(${function.parameters.definitionString()}): " +
                        "$returnType = $returnType${
                            if (function.returnType.isSubclassOf(jsSyntaxDeclaration))
                                "" else ".syntax"
                        }(${chainOperationDeclaration.name}(this, " +
                        "${invocationOperationDeclaration.name}(\"$functionName\", " +
                        "${function.parameters.listString()})))\n"
            )
        }

        append("}\n")
    }

    private fun findDeclarations(resolver: Resolver): Sequence<KSClassDeclaration>? {
        val symbols = resolver.getSymbolsWithAnnotation(jsClassAnnotationName)
            .filterIsInstance<KSClassDeclaration>()
        if (!symbols.iterator().hasNext()) {
            return null
        }
        return symbols
    }

    private fun writeToFile(
        fileName: String,
        packageName: String,
        declaration: KSClassDeclaration,
        codeBuilder: StringBuilder
    ) {
        val file = codeGenerator.createNewFile(
            dependencies = Dependencies(false, declaration.containingFile!!),
            packageName = packageName,
            fileName = fileName,
            extensionName = "kt"
        )
        OutputStreamWriter(file).use { it.write(codeBuilder.toString()) }
        logger.info("Generated interface file for class: $fileName.kt")
    }
}
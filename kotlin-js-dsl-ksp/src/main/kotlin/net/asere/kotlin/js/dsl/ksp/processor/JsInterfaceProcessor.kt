package net.asere.kotlin.js.dsl.ksp.processor

import com.google.devtools.ksp.closestClassDeclaration
import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.*
import com.google.devtools.ksp.symbol.ClassKind
import com.google.devtools.ksp.symbol.KSAnnotated
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSValueParameter
import com.google.devtools.ksp.symbol.Visibility
import com.google.devtools.ksp.validate
import net.asere.kotlin.js.dsl.ksp.extension.fullName
import net.asere.kotlin.js.dsl.ksp.extension.name
import net.asere.kotlin.js.dsl.ksp.extension.typeFullName
import net.asere.kotlin.js.dsl.ksp.extension.typeName
import net.asere.kotlin.js.dsl.ksp.extension.typePackage
import java.io.OutputStreamWriter

class JsInterfaceProcessor(
    private val codeGenerator: CodeGenerator,
    private val logger: KSPLogger
) : SymbolProcessor {

    private val jsClassAnnotationName = "net.asere.kotlin.js.dsl.ksp.annotation.JsClass"
    private val jsChainOperationName = "net.asere.kotlin.js.dsl.syntax.operation.ChainOperation"
    private val jsInvocationOperationName = "net.asere.kotlin.js.dsl.syntax.operation.InvocationOperation"
    private val jsObjectName = "net.asere.kotlin.js.dsl.type.obj.JsObject"
    private val jsElementName = "net.asere.kotlin.js.dsl.JsElement"
    private lateinit var chainOperationDeclaration: KSClassDeclaration
    private lateinit var invocationOperationDeclaration: KSClassDeclaration
    private lateinit var jsObjectDeclaration: KSClassDeclaration
    private lateinit var jsElementDeclaration: KSClassDeclaration

    override fun process(resolver: Resolver): List<KSAnnotated> {

        resolver.checkDependencies()

        val declarations = findDeclarations(resolver) ?: return emptyList()

        for (declaration in declarations) {
            createInterface(declaration)
        }

        return declarations.filterNot { it.validate() }.toList()
    }

    private fun Resolver.checkDependencies() {
        val message = "class cannot be found. Have you included the dsl in your project dependencies?"
        chainOperationDeclaration = getClassDeclarationByName(
            name = getKSNameFromString(jsChainOperationName)
        ) ?: throw IllegalStateException("ChainOperation $message")

        invocationOperationDeclaration = getClassDeclarationByName(
            name = getKSNameFromString(jsInvocationOperationName)
        ) ?: throw IllegalStateException("InvocationOperation $message")

        jsObjectDeclaration = getClassDeclarationByName(
            name = getKSNameFromString(jsObjectName)
        ) ?: throw IllegalStateException("JsObject $message")

        jsElementDeclaration = getClassDeclarationByName(
            name = getKSNameFromString(jsElementName)
        ) ?: throw IllegalStateException("JsElement $message")
    }

    private fun createInterface(declaration: KSClassDeclaration) {
        val packageName = declaration.packageName.asString()
        val codeBuilder = StringBuilder()
        if (packageName.isNotBlank()) {
            codeBuilder.append("package $packageName\n\n")
        }
        appendImports(declaration, codeBuilder)
        val interfaceName = appendDeclaration(declaration, codeBuilder)
        appendProperties(declaration, codeBuilder)
        appendMethods(declaration, codeBuilder)
        writeToFile(
            fileName = interfaceName,
            packageName = packageName,
            declaration = declaration,
            codeBuilder = codeBuilder
        )
    }

    private fun appendDeclaration(declaration: KSClassDeclaration, codeBuilder: StringBuilder): String {
        val jsClassAnnotation = declaration.annotations.find {
            it.annotationType.resolve().declaration.qualifiedName?.asString() == jsClassAnnotationName
        } ?: throw IllegalStateException("@JsClass annotation not found on ${declaration.qualifiedName?.asString()}")

        val interfaceNameFromAnnotation =
            jsClassAnnotation.arguments.find { it.name?.asString() == "name" }?.value as? String
        val interfaceName = if (interfaceNameFromAnnotation.isNullOrBlank()) {
            "Js${declaration.simpleName.asString()}"
        } else {
            interfaceNameFromAnnotation
        }
        val superTypes = declaration.superTypeInterfacesNames
        codeBuilder.append(
            "interface $interfaceName : ${
                if (superTypes.isNotEmpty()) superTypes.joinToString(", ") { it.name } else "JsObject"
            } {\n"
        )
        return interfaceName
    }

    private fun appendImports(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        val imports: MutableSet<String> = mutableSetOf()
        imports.add(chainOperationDeclaration.fullName)
        imports.add(invocationOperationDeclaration.fullName)
        declaration.getJsAvailableProperties()
            .forEach { property ->
                imports.add(property.typeFullName)
                imports.add("${property.typePackage}.syntax")
            }
        if (declaration.superTypeInterfacesNames.isEmpty()) {
            imports.add(jsObjectDeclaration.fullName)
        } else {
            declaration.superTypeInterfacesNames.forEach {
                imports.add(it.fullName)
            }
        }
        for (function in declaration.getJsAvailableFunctions()) {
            imports.add(function.returnType!!.resolve().declaration.fullName)
            for (param in function.parameters) {
                imports.add(param.type.resolve().declaration.fullName)
            }
        }
        imports.forEach {
            codeBuilder.append("import $it\n")
        }
        codeBuilder.append("\n")
    }

    private fun appendProperties(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        declaration.getJsAvailableProperties().forEach { property ->
            val propertyName = property.name
            val propertyType = property.typeName
            codeBuilder.append("  val $propertyName: $propertyType get() = $propertyType.syntax(${chainOperationDeclaration.name}(this, \"$propertyName\"))\n")
        }
    }

    private fun appendMethods(declaration: KSClassDeclaration, codeBuilder: StringBuilder) {
        declaration.getJsAvailableFunctions().forEach { function ->
            val functionName = function.name
            val returnType = function.returnType?.resolve()?.declaration?.name ?: "Unit"
            codeBuilder.append("  fun $functionName(${function.parameters.definitionString()}): " +
                    "$returnType = $returnType.syntax(${chainOperationDeclaration.name}(this, " +
                    "${invocationOperationDeclaration.name}(\"$functionName\", " +
                    "${function.parameters.listString()})))\n")
        }

        codeBuilder.append("}\n")
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

    private fun KSClassDeclaration.getJsAvailableFunctions() = getAllFunctions()
        .filter { it.getVisibility() == Visibility.PUBLIC }
        .filter { !it.isConstructor() }
        .filter { it.returnType?.resolve()?.declaration.isJsElement() }

    private fun KSClassDeclaration.getJsAvailableProperties() = getAllProperties()
        .filter { it.getVisibility() == Visibility.PUBLIC && it.isJsElement() }

    private fun KSPropertyDeclaration?.isJsElement() = this?.type?.resolve()?.declaration.isJsElement()

    private fun KSDeclaration?.isJsElement() = this?.closestClassDeclaration()
        ?.isSubclassOf(jsElementDeclaration) ?: false

    private val KSClassDeclaration.superTypeInterfacesNames: List<KSDeclaration>
        get() = superTypes
            .filter {
                it.resolve().declaration is KSClassDeclaration &&
                        (it.resolve().declaration as KSClassDeclaration).classKind == ClassKind.INTERFACE
            }
            .map { it.resolve().declaration }.toList()

    private fun List<KSValueParameter>.definitionString() = joinToString(", ") { param ->
        val paramName = param.name?.asString()
        val paramType = param.type.resolve().declaration.name
        "$paramName: $paramType"
    }

    private fun List<KSValueParameter>.listString() = joinToString(", ") { param ->
        "${param.name?.asString()}"
    }

    fun KSClassDeclaration.isSubclassOf(superClass: KSClassDeclaration): Boolean {
        if (qualifiedName?.asString() == superClass.qualifiedName?.asString()) {
            return true
        }
        for (superTypeRef in superTypes) {
            val superTypeDeclaration = superTypeRef.resolve().declaration
            if (superTypeDeclaration is KSClassDeclaration && superTypeDeclaration.qualifiedName?.asString() != "kotlin.Any") {
                if (superTypeDeclaration.isSubclassOf(superClass)) {
                    return true
                }
            }
        }
        return false
    }

}
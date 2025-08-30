package net.asere.kotlin.js.dsl.ksp.extension

import com.google.devtools.ksp.closestClassDeclaration
import com.google.devtools.ksp.getVisibility
import com.google.devtools.ksp.isConstructor
import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSClassDeclaration
import com.google.devtools.ksp.symbol.KSDeclaration
import com.google.devtools.ksp.symbol.KSFunctionDeclaration
import com.google.devtools.ksp.symbol.KSPropertyDeclaration
import com.google.devtools.ksp.symbol.KSType
import com.google.devtools.ksp.symbol.KSTypeArgument
import com.google.devtools.ksp.symbol.Visibility
import net.asere.kotlin.js.dsl.ksp.processor.jsClassAnnotationName
import net.asere.kotlin.js.dsl.ksp.processor.jsElementName
import kotlin.sequences.forEach

val KSDeclaration.fullName: String get() = qualifiedName?.asString() ?: "Any"
val KSDeclaration.fullJsName: String get() = "${packageName.asString()}.${jsName}"
val KSDeclaration.name: String get() = simpleName.asString()

fun KSDeclaration?.isJsElement(resolver: Resolver): Boolean {
    val jsElement = resolver.loadClass(jsElementName)
    return this.isSubclassOf(jsElement)
}

fun KSDeclaration?.isSubclassOf(classDeclaration: KSClassDeclaration) = this
    ?.closestClassDeclaration()
    ?.isSubclassOf(classDeclaration)
    ?: false

fun KSDeclaration.isAny() = qualifiedName?.asString() == "kotlin.Any"

fun KSDeclaration.getGenericReturnTypes(resolver: Resolver): Set<KSType> {
    val types: MutableSet<KSType> = mutableSetOf()
    fun checkArguments(argument: KSTypeArgument) {
        if (argument.type?.isGenericTypeParameter() ?: false) {
            argument.type?.let { type -> types.add(type.resolve()) }
        }
        argument.type?.resolve()?.arguments?.map {
            checkArguments(it)
        }
    }
    if (this is KSClassDeclaration) {
        getAllProperties().filter {
            (it.getVisibility() == Visibility.PUBLIC && it.isJsElement(resolver)) || it.type.isGenericTypeParameter()
        }.forEach { property ->
            if (property.type.isGenericTypeParameter()) {
                types.add(property.type.resolve())
            } else {
                property.type.resolve().arguments.map {
                    checkArguments(it)
                }

            }
        }
        declarations.filterIsInstance<KSFunctionDeclaration>()
            .filter { it.getVisibility() == Visibility.PUBLIC }
            .filter { !it.isConstructor() }
            .filter {
                it.returnType?.resolve()?.declaration.isJsElement(resolver) || it.returnType.isGenericTypeParameter()
            }.forEach { function ->
                if (function.returnType.isGenericTypeParameter()) {
                    function.returnType?.resolve()?.let { types.add(it) }
                } else {
                    val generics = function.returnType?.resolve()?.arguments?.map {
                        checkArguments(it)
                    } ?: listOf()
                    if (generics.isNotEmpty()) {
                        function.returnType?.resolve()?.let { types.add(it) }
                    }
                }
            }
    }
    if (this is KSPropertyDeclaration) {
        types.addAll(type.resolve().declaration.getGenericReturnTypes(resolver))
    }
    return types
}

val KSDeclaration.jsName: String get() {
    if (this is KSClassDeclaration) return jsName
    return name
}
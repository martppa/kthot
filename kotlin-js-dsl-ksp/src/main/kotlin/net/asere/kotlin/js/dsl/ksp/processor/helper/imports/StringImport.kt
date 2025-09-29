package net.asere.kotlin.js.dsl.ksp.processor.helper.imports

class StringImport(import: String) : ImportSyntaxBlock {

    override val value: String = import
}
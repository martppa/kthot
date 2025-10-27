package net.asere.kthot.js.dsl.ksp.processor.js

abstract class JavaScriptFile {
    private val mutableRequirements: MutableSet<String> =  mutableSetOf()
    val requirements get() = mutableRequirements.toList()

    protected fun require(url: String) {
        mutableRequirements.add(url)
    }
}
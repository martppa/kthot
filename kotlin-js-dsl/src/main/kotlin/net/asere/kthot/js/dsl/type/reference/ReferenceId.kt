package net.asere.kthot.js.dsl.type.reference

object ReferenceId {
    private var currentStringRefId = 0
    fun nextRefInt(): Int = currentStringRefId++
}
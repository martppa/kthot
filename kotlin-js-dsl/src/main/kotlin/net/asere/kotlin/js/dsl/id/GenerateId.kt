package net.asere.kotlin.js.dsl.id

import java.util.UUID

fun generateId() = UUID.randomUUID().toString().replace("-", "")
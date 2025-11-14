package net.asere.kthot.js.dsl.sample.app

import io.ktor.server.engine.*
import io.ktor.server.html.*
import io.ktor.server.http.content.*
import io.ktor.server.netty.*
import io.ktor.server.routing.*
import kotlinx.html.body
import kotlinx.html.div
import kotlinx.html.head
import kotlinx.html.id
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.dom.type.content.document.Document
import net.asere.kthot.js.dsl.dom.type.content.document.createElement
import net.asere.kthot.js.dsl.dom.type.content.document.getElementById
import net.asere.kthot.js.dsl.dom.type.data.event.dom.JsDomEvent
import net.asere.kthot.js.dsl.dom.type.structure.div.JsDiv
import net.asere.kthot.js.dsl.dom.type.structure.div.def
import net.asere.kthot.js.dsl.dom.type.structure.paragraph.JsParagraph
import net.asere.kthot.js.dsl.dom.type.structure.paragraph.def
import net.asere.kthot.js.dsl.dom.type.window.Window
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.ksp.Kthot
import net.asere.kthot.js.dsl.provider.register
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.JsRepoDataSource
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch.JsResponse
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch.syntax
import net.asere.kthot.js.dsl.sample.app.scrirpt.model.JsRepo
import net.asere.kthot.js.dsl.syntax.async.await
import net.asere.kthot.js.dsl.syntax.module.Import
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.array.def
import net.asere.kthot.js.dsl.type.array.syntax
import net.asere.kthot.js.dsl.type.function.AsyncFunction
import java.io.File

fun main() {
    register { element -> JsArray.syntax<JsRepo>(value = element) }
    register { element -> JsResponse.syntax<JsArray<JsRepo>>(value = element) }
    Kthot.initialize()
    val server = embeddedServer(Netty, 3000) {
        routing {
            staticFiles("/", File("js"))
            get("/home") {
                call.respondHtml {
                    head {
                        jslScript {
                            Import(JsRepoDataSource.Module, JsRepoDataSource.Module.fetchRepos)
                            val fetchFunction = AsyncFunction(name = "fetchFunction") {
                                val listDiv = Const { JsDiv.def("listDiv") } assign Document.getElementById("list")
                                val repos = Const { JsArray.def<JsRepo>("repos") } assign await { JsRepoDataSource.fetchRepos() }
                                +repos.forEach {
                                    val paragraph = Const { JsParagraph.def("paragraph") } assign Document.createElement("div")
                                    +paragraph.setTextContent(it.name)
                                    +listDiv.appendChild(paragraph)
                                }
                            }
                            +Window.addEventListener(event = JsDomEvent.EVENT_LOAD) {
                                +fetchFunction()
                            }
                        }
                    }
                    body {
                        div {
                            id = "list"
                        }
                    }
                }
            }
        }
    }
    server.start(true)
}
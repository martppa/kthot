package net.asere.kotlin.js.dsl

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import net.asere.kotlin.js.dsl.declaration.Const
import net.asere.kotlin.js.dsl.dom.type.content.document.Document
import net.asere.kotlin.js.dsl.dom.type.content.document.getElementById
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.JsButton
import net.asere.kotlin.js.dsl.dom.type.structure.form.button.def
import net.asere.kotlin.js.dsl.dom.type.structure.paragraph.JsParagraph
import net.asere.kotlin.js.dsl.dom.type.structure.paragraph.def
import net.asere.kotlin.js.dsl.html.jslScript
import net.asere.kotlin.js.dsl.ksp.KotlinJsl
import net.asere.kotlin.js.dsl.log.Log

fun main(vararg args: String) {
    val result = createHTML().html {
        head {
            jslScript {
                KotlinJsl.initialize()
                val button = Const { JsButton.def("button") } assign Document.getElementById("button")
                +button.setOnClick {
                    val title = Const { JsParagraph.def("title") } assign Document.getElementById("title")
                    +title.setTextContent("Clicked!")
                    Log("Clicked!")
                }
            }
        }
        body {
            div {
                p {
                    id = "title"
                }
            }
            button {
                id = "button"
                +"Click me"
            }
        }
    }
    println(result)

    //<html>
    //  <head>
    //    <script>
    //      const button = document.getElementById('button')
    //      button.addEventListener('click', (event) => {
    //        console.log('Clicked!')
    //      })
    //    </script>
    //  </head>
    //  <body>
    //    <button id="button">Click me</button>
    //  </body>
    //</html>
}
package net.asere.kthot.js.dsl.sample.snippets

import kotlinx.html.*
import kotlinx.html.stream.createHTML
import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.dom.type.content.document.Document
import net.asere.kthot.js.dsl.dom.type.content.document.getElementById
import net.asere.kthot.js.dsl.dom.type.html.form.button.JsButtonElement
import net.asere.kthot.js.dsl.dom.type.html.form.button.def
import net.asere.kthot.js.dsl.dom.type.html.paragraph.JsParagraphElement
import net.asere.kthot.js.dsl.dom.type.html.paragraph.def
import net.asere.kthot.js.dsl.html.jslScript
import net.asere.kthot.js.dsl.ksp.Kthot
import net.asere.kthot.js.dsl.log.Log
import net.asere.kthot.js.dsl.type.string.js

fun main(vararg args: String) {
    val result = createHTML().html {
        head {
            jslScript {
                Kthot.initialize()
                val button = Const { JsButtonElement.def("button") } assign Document.getElementById("button")
                +button.setOnClick {
                    val title = Const { JsParagraphElement.def("title") } assign Document.getElementById("title")
                    title.textContent assign "Clicked!".js
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
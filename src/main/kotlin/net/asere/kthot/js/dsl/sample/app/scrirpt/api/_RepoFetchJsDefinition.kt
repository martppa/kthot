package net.asere.kthot.js.dsl.sample.app.scrirpt.api

import net.asere.kthot.js.dsl.declaration.Const
import net.asere.kthot.js.dsl.ksp.annotation.JsAsync
import net.asere.kthot.js.dsl.ksp.annotation.JsFunction
import net.asere.kthot.js.dsl.ksp.annotation.JsFunctionModule
import net.asere.kthot.js.dsl.ksp.processor.js.JavaScriptModule
import net.asere.kthot.js.dsl.sample.app.scrirpt.api.fetch.*
import net.asere.kthot.js.dsl.sample.app.scrirpt.model.JsRepo
import net.asere.kthot.js.dsl.syntax.async.await
import net.asere.kthot.js.dsl.syntax.js
import net.asere.kthot.js.dsl.syntax.jsreturn.Return
import net.asere.kthot.js.dsl.type.array.JsArray
import net.asere.kthot.js.dsl.type.promise.JsPromise
import net.asere.kthot.js.dsl.type.promise.syntax
import net.asere.kthot.js.dsl.type.string.js

@JsFunctionModule(name = "JsRepoDataSource")
internal class _RepoFetchJsDefinition : JavaScriptModule() {
    init {
        importModule(JsRepo.Module)
        importModule(JsFetchData.Module)
    }

    @JsAsync
    @JsFunction
    fun fetchRepos(): JsPromise<JsArray<JsRepo>> = JsPromise.syntax(js {
        val data = Const { JsFetchData.def("data") } assign JsFetchData.new()
        data.method assign FETCH_METHOD_GET
        val response = Const { JsResponse.def<JsArray<JsRepo>>("response") } assign await {
            JsFetch.fetch(
                url = "https://api.github.com/orgs/microsoft/repos".js,
                data = data
            )
        }
        Return { response.json() }
    })
}
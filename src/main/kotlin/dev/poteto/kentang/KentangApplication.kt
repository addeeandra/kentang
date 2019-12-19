package dev.poteto.kentang

import dev.poteto.kentang.http.BaseApplication
import dev.poteto.kentang.impl.Registerable
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.features.StatusPages
import io.ktor.routing.Routing
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer

abstract class KentangApplication : BaseApplication() {

    open val cors: CORS.Configuration.() -> Unit = {}
    open val statusPages: StatusPages.Configuration.() -> Unit = {}
    open val contentNegotiation: ContentNegotiation.Configuration.() -> Unit = {}

    fun startEmbeddedServer(
        preProcess: Application.() -> Unit = {},
        postProcess: Application.() -> Unit = {}
    ) {
        embeddedServer(engine, port, module = {
            preProcess.invoke(this)
            install(CORS) { cors.invoke(this) }
            install(StatusPages) { statusPages.invoke(this) }
            install(ContentNegotiation) { contentNegotiation.invoke(this) }
            routing {
                routes.forEach {
                    val routeInstance = it.constructors.first().call() as Registerable<*>
                    (routeInstance as Registerable<Routing>).register(this)
                }
            }
            postProcess.invoke(this)
        }).start()
    }

}
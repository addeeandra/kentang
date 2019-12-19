package dev.poteto.kentang.http

import io.ktor.routing.Routing

abstract class BaseRoute {

    protected abstract val routes: Routing.() -> Unit

}
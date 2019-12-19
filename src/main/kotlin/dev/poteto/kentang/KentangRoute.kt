package dev.poteto.kentang

import dev.poteto.kentang.http.BaseRoute
import dev.poteto.kentang.impl.Dispatcher
import dev.poteto.kentang.impl.Registerable
import dev.poteto.kentang.impl.Worker
import io.ktor.routing.Routing

abstract class KentangRoute : BaseRoute(), Dispatcher, Registerable<Routing> {

    override fun register(context: Routing) {
        routes(context)
    }

    override fun dispatch(worker: Worker) {
        worker.handle()
    }

}
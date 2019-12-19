package dev.poteto.kentang.http

import io.ktor.server.engine.ApplicationEngineFactory
import kotlin.reflect.KClass

abstract class BaseApplication {

    abstract val engine: ApplicationEngineFactory<*, *>

    abstract val routes: List<KClass<*>>

    open val port: Int = 8002

}
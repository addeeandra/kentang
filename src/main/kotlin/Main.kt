import dev.poteto.kentang.KentangApplication
import dev.poteto.kentang.KentangRoute
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.post
import io.ktor.server.engine.ApplicationEngineFactory
import io.ktor.server.netty.Netty
import kotlin.reflect.KClass

class UserRoute : KentangRoute() {

    override val routes: Routing.() -> Unit
        get() = {
            get("/") {
                call.respondText("WOWOWOWO")
            }
            get("/users") {
                call.respondText("TEST USERSSS")
            }
            post("/users") {
                call.respondText("POST USER")
            }
        }

}

class MyApp : KentangApplication() {

    override val engine: ApplicationEngineFactory<*, *>
        get() = Netty

    override val routes: List<KClass<*>>
        get() = listOf(UserRoute::class)

}

fun main(args: Array<String>) {
    MyApp().startEmbeddedServer()
}
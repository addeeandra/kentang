Kentang is a framework for creating web with fast and structured with minimal effort on top of [Ktor](https://github.com/ktorio/ktor).

1. Create a route class by extending `KentangRoute`
```kotlin
import dev.poteto.kentang.KentangRoute
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.*

class UserRoute : KentangRoute() {

    override val routes: Routing.() -> Unit
        get() = {
            get("/") {
                call.respondText("Hello World!")
            }
        }

}
``` 

2. Create your app class by extending `KentangApplication`
```kotlin
import dev.poteto.kentang.KentangApplication
import io.ktor.server.engine.ApplicationEngineFactory
import io.ktor.server.netty.Netty
import kotlin.reflect.KClass

class MyApp : KentangApplication() {

    override val engine: ApplicationEngineFactory<*, *>
        get() = Netty

    override val routes: List<KClass<*>>
        get() = listOf(UserRoute::class)

}
```

3. Call your application class within main function
```kotlin
fun main() {
    MyApp().startEmbeddedServer()
}
```
Kentang is a helper class (framework wannabe) for creating web application using Kotlin in fast and clean with minimal effort based on [Ktor](https://github.com/ktorio/ktor).


### 1. Create a route class by extending `KentangRoute`
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


### 2. Create your app class by extending `KentangApplication`
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


### 3. Call your application class within main function
```kotlin
fun main() {
    MyApp().startEmbeddedServer()
}
```

### 4. Access it by typing http://localhost:8002 in your browser
![Preview](https://i.ibb.co/Wy23GQ0/image.png "Preview")

### TODO
- A simple worker / job dispatcher
- A single controller attached to single route

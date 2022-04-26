# Helloworld

An [m3o.com](https://m3o.com) API. For example usage see [m3o.com/helloworld/api](https://m3o.com/helloworld/api).

Endpoints:

## Call

Return a personalised Hello message


[https://m3o.com/helloworld/api#Call](https://m3o.com/helloworld/api#Call)

```kotlin
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.services.HelloWorldService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = HelloWorldService.call("John")
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}
```
## Stream

Stream a personalised Hello message


[https://m3o.com/helloworld/api#Stream](https://m3o.com/helloworld/api#Stream)

```kotlin
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.services.HelloWorldService

fun main() {
    M3O.initialize("NjJhODlhMmMtOGQ3Ni00YzljLWJhMzAtNGFkYzBhZTc5Yzcz")

    try {
        val socket = HelloWorldService.stream("John", 10) { socketError, response ->
            if (socketError == null) {
                println(response)
            } else {
                println(socketError)
            }
        }
    } catch (e: Exception) {
        println(e)
    }
}
```
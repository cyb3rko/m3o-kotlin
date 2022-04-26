package examples.helloworld.call

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

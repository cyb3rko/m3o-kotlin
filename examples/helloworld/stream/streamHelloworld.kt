package examples.helloworld.stream

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

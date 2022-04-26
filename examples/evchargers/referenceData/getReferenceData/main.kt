package examples.evchargers.referenceData.getReferenceData

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.services.EVChargersService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = EVChargersService.referenceData()
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}

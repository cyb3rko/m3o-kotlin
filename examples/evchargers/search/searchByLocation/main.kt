package examples.evchargers.search.searchByLocation

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.EVChargerCoordinates
import com.cyb3rko.m3okotlin.services.EVChargersService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = EVChargersService.search(
            distance = 2000,
            location = EVChargerCoordinates(
                51.53336351319885,
                -0.0252
            ),
            maxResults = 2
        )
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}

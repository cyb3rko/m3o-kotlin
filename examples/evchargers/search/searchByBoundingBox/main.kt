package examples.evchargers.search.searchByBoundingBox

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.EVChargerCoordinates
import com.cyb3rko.m3okotlin.data.EVChargerLocationBox
import com.cyb3rko.m3okotlin.services.EVChargersService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = EVChargersService.search(
            EVChargerLocationBox(
                EVChargerCoordinates(51.52627543859447, -0.03635349400295168),
                EVChargerCoordinates(51.56717121807993, -0.002293530559768285)
            ),
            maxResults = 2
        )
        println(response)
    } catch (e: Exception) {
        println(e)
    }
}

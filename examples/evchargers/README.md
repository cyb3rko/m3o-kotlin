# Evchargers

An [m3o.com](https://m3o.com) API. For example usage see [m3o.com/evchargers/api](https://m3o.com/evchargers/api).

Endpoints:

## Search

Search by giving a coordinate and a max distance, or bounding box and optional filters


[https://m3o.com/evchargers/api#Search](https://m3o.com/evchargers/api#Search)

```kotlin
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
```
## Search

Search by giving a coordinate and a max distance, or bounding box and optional filters


[https://m3o.com/evchargers/api#Search](https://m3o.com/evchargers/api#Search)

```kotlin
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
```
## Search

Search by giving a coordinate and a max distance, or bounding box and optional filters


[https://m3o.com/evchargers/api#Search](https://m3o.com/evchargers/api#Search)

```kotlin
import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.EVChargerCoordinates
import com.cyb3rko.m3okotlin.services.EVChargersService

suspend fun main() {
    M3O.initialize("M3O_API_TOKEN")

    try {
        val response = EVChargersService.search(
            distance = 2000,
            levels = listOf("3"),
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
```
## ReferenceData

Retrieve reference data as used by this API and in conjunction with the Search endpoint


[https://m3o.com/evchargers/api#ReferenceData](https://m3o.com/evchargers/api#ReferenceData)

```kotlin
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
```
package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.PlacesNearbyRequest
import com.cyb3rko.m3okotlin.data.PlacesNearbyResponse
import com.cyb3rko.m3okotlin.data.PlacesSearchRequest
import com.cyb3rko.m3okotlin.data.PlacesSearchResponse
import io.ktor.client.request.*

private const val SERVICE = "place"

object PlacesService {

    suspend fun nearby(
        location: String,
        keyword: String = "",
        name: String = "",
        openNow: Boolean = false,
        radius: Int = 0,
        type: String = ""
    ): PlacesNearbyResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Nearby")) {
            body = PlacesNearbyRequest(keyword, location, name, openNow, radius, type)
        }
    }

    suspend fun search(
        location: String,
        query: String,
        openNow: Boolean = false,
        radius: Int = 0,
        type: String = ""
    ): PlacesSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = PlacesSearchRequest(location, openNow, query, radius, type)
        }
    }
}

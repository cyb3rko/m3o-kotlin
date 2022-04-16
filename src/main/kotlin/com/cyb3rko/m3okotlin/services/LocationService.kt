package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.LocationReadRequest
import com.cyb3rko.m3okotlin.data.LocationSaveRequest
import com.cyb3rko.m3okotlin.data.LocationSearchRequest
import io.ktor.client.request.*

private const val SERVICE = "location"

object LocationService {

    suspend fun read(id: String): LocationReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
            body = LocationReadRequest(id)
        }
    }

    suspend fun save(entity: Location) {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
            body = LocationSaveRequest(entity)
        }
    }

    suspend fun search(
        center: LocationCoordinates,
        numEntities: Int,
        radius: Int,
        type: String
    ): LocationSearchResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Search")) {
            body = LocationSearchRequest(center, numEntities, radius, type)
        }
    }
}
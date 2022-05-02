package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "location"

/**
 * **Real time GPS location tracking and search**
 *
 * Send, store, and search real time GPS point data and tracking information
 * using the location API.
 *
 * @since 0.1.0
 */
object LocationService {

    /**
     * Read an entity by its ID
     * @since 0.1.0
     */
    suspend fun read(id: String): LocationReadResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Read")) {
            body = LocationReadRequest(id)
        }
    }

    /**
     * Save an entity's current position
     * @since 0.1.0
     */
    suspend fun save(entity: Location) {
        return ktorHttpClient.post(getUrl(SERVICE, "Save")) {
            body = LocationSaveRequest(entity)
        }
    }

    /**
     * Search for entities in a given radius
     * @since 0.1.0
     */
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

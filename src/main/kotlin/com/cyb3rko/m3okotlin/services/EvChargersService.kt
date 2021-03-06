package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "evchargers"

/**
 * **Find electric vehicle (EV) chargers wherever you go**
 *
 * This is the E(lectric) V(ehicle) chargers API.
 *
 * @since 0.1.0
 */
object EvChargersService {

    /**
     * Retrieve reference data as used by this API and in conjunction with the
     * Search endpoint
     * @since 0.1.0
     */
    suspend fun referenceData(): EvChargersReferenceDataResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ReferenceData"))
    }

    /**
     * Search by giving a coordinate and a max distance, or bounding box and
     * optional filters
     * @since 0.1.0
     */
    suspend fun search(
        box: EvChargerLocationBox = EvChargerLocationBox(EvChargerCoordinates(0.0, 0.0), EvChargerCoordinates(0.0, 0.0)),
        connectionTypes: List<String> = emptyList(),
        countryId: String = "",
        distance: Int = 5000,
        levels: List<String> = emptyList(),
        location: EvChargerCoordinates = EvChargerCoordinates(0.0, 0.0),
        maxResults: Int = 100,
        minPower: Int = 0,
        operators: List<String> = emptyList(),
        usageTypes: List<String> = emptyList()
    ): EvChargersSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = if (location.latitude == 0.0 && location.longitude == 0.0) {
                EvChargersSearchBoxRequest(
                    box,
                    connectionTypes,
                    countryId,
                    distance,
                    levels,
                    maxResults,
                    minPower,
                    operators,
                    usageTypes
                )
            } else {
                EvChargersSearchLocationRequest(
                    connectionTypes,
                    countryId,
                    distance,
                    levels,
                    location,
                    maxResults,
                    minPower,
                    operators,
                    usageTypes
                )
            }
        }
    }
}

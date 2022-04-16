package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "evchargers"

object EVChargersService {

    suspend fun referenceData(): EVChargersReferenceDataResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "ReferenceData"))
    }

    suspend fun search(
        box: EVChargerLocationBox = EVChargerLocationBox(EVChargerCoordinates(0.0, 0.0), EVChargerCoordinates(0.0, 0.0)),
        connectionTypes: List<String> = emptyList(),
        countryId: String = "",
        distance: Int = 5000,
        levels: List<String> = emptyList(),
        location: EVChargerCoordinates = EVChargerCoordinates(0.0, 0.0),
        maxResults: Int = 100,
        minPower: Int = 0,
        operators: List<String> = emptyList(),
        usageTypes: List<String> = emptyList()
    ): EVChargersSearchResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Search")) {
            body = if (location.latitude == 0.0 && location.longitude == 0.0) {
                EVChargersSearchBoxRequest(
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
                EVChargersSearchLocationRequest(
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
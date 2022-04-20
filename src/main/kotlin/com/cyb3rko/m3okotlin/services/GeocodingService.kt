package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.GeocodingLookupRequest
import com.cyb3rko.m3okotlin.data.GeocodingLookupResponse
import com.cyb3rko.m3okotlin.data.GeocodingReverseRequest
import com.cyb3rko.m3okotlin.data.GeocodingReverseResponse
import io.ktor.client.request.*

private const val SERVICE = "geocoding"

object GeocodingService {

    suspend fun lookup(
        address: String = "",
        city: String = "",
        country: String = "",
        postcode: String = ""
    ): GeocodingLookupResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Lookup")) {
            body = GeocodingLookupRequest(address, city, country, postcode)
        }
    }

    suspend fun reverse(latitude: Double, longitude: Double): GeocodingReverseResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reverse")) {
            body = GeocodingReverseRequest(latitude, longitude)
        }
    }
}
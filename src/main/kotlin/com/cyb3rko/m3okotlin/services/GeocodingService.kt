package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.GeocodingLookupRequest
import com.cyb3rko.m3okotlin.data.GeocodingLookupResponse
import com.cyb3rko.m3okotlin.data.GeocodingReverseRequest
import com.cyb3rko.m3okotlin.data.GeocodingReverseResponse
import io.ktor.client.request.*

private const val SERVICE = "geocoding"

/**
 * **Address geocoding and reverse lookup**
 *
 * The geocoding service provides address to latitude longitude geocoding as
 * well as the reverse. It's useful for building mapping or location based
 * services.
 *
 * @since 0.1.0
 */
object GeocodingService {

    /**
     * Lookup returns a geocoded address including normalized address and gps
     * coordinates. All fields are optional, provide more to get more accurate
     * results
     * @since 0.1.0
     */
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

    /**
     * Reverse lookup an address from gps coordinates
     * @since 0.1.0
     */
    suspend fun reverse(latitude: Double, longitude: Double): GeocodingReverseResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reverse")) {
            body = GeocodingReverseRequest(latitude, longitude)
        }
    }
}

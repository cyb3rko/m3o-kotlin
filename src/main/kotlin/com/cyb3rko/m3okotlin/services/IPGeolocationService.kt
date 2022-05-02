package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IPGeolocationRequest
import com.cyb3rko.m3okotlin.data.IPGeolocationResponse
import io.ktor.client.request.*

private const val SERVICE = "ip"

/**
 * **IP to geolocation lookup**
 *
 * The IP service provides IP to geolocation lookup including asn, city,
 * country, timezone, and latitude/longitude.
 *
 * @since 0.1.0
 */
object IPGeolocationService {

    /**
     * Lookup the geolocation information for an IP address
     * @since 0.1.0
     */
    suspend fun lookup(ip: String): IPGeolocationResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = IPGeolocationRequest(ip)
        }
    }
}

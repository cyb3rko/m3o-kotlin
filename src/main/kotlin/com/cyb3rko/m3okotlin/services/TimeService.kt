package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.TimeNowRequest
import com.cyb3rko.m3okotlin.data.TimeNowResponse
import com.cyb3rko.m3okotlin.data.TimeZoneRequest
import com.cyb3rko.m3okotlin.data.TimeZoneResponse
import io.ktor.client.request.*

private const val SERVICE = "time"

/**
 * **Time, date, and timezone info**
 *
 * Get the time, date, and timezone info for any given location in the world.
 *
 * @since 0.1.0
 */
object TimeService {

    /**
     * Get the current time
     * @since 0.1.0
     */
    suspend fun now(location: String = ""): TimeNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
            body = TimeNowRequest(location)
        }
    }

    /**
     * Get the timezone info for a specific location
     * @since 0.1.0
     */
    suspend fun zone(location: String): TimeZoneResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Zone")) {
            body = TimeZoneRequest(location)
        }
    }
}

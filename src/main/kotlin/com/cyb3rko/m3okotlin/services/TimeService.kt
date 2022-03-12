package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "time"

object TimeService {

    suspend fun now(location: String = ""): TimeNowResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Now")) {
            body = TimeNowRequest(location)
        }
    }

    suspend fun zone(location: String): TimeZoneResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Zone")) {
            body = TimeZoneRequest(location)
        }
    }
}
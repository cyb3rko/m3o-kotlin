package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IPGeolocationRequest
import com.cyb3rko.m3okotlin.data.IPGeolocationResponse
import io.ktor.client.request.*

private const val SERVICE = "ip"

object IPGeolocationService {

    suspend fun lookup(ip: String): IPGeolocationResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = IPGeolocationRequest(ip)
        }
    }
}
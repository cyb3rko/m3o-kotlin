package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.IP2GeoRequest
import com.cyb3rko.m3okotlin.data.IP2GeoResponse
import io.ktor.client.request.*

private const val SERVICE = "ip"

object IP2GeoService {

    suspend fun lookup(ip: String): IP2GeoResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = IP2GeoRequest(ip)
        }
    }
}
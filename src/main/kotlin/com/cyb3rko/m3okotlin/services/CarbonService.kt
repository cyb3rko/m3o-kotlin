package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "carbon"

object CarbonService {

    suspend fun offset(): CarbonResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Offset"))
    }
}
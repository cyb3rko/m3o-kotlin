package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.VehicleRequest
import com.cyb3rko.m3okotlin.data.VehicleResponse
import io.ktor.client.request.*

private const val SERVICE = "vehicle"

object VehicleService {

    suspend fun lookup(registration: String): VehicleResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Lookup")) {
            body = VehicleRequest(registration)
        }
    }
}
package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "minecraft"

object MinecraftService {

    suspend fun ping(address: String): MinecraftResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ping")) {
            body = MinecraftRequest(address)
        }
    }
}
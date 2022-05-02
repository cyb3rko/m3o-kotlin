package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.MinecraftRequest
import com.cyb3rko.m3okotlin.data.MinecraftResponse
import io.ktor.client.request.*

private const val SERVICE = "minecraft"

/**
 * **Minecraft server ping**
 *
 * Ping your Minecraft servers for latency, player count, etc.
 *
 * @since 0.1.0
 */
object MinecraftService {

    /**
     * Ping a minecraft server
     * @since 0.1.0
     */
    suspend fun ping(address: String): MinecraftResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ping")) {
            body = MinecraftRequest(address)
        }
    }
}

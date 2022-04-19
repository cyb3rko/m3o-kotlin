package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.TunnelRequest
import com.cyb3rko.m3okotlin.data.TunnelResponse
import io.ktor.client.request.*

private const val SERVICE = "tunnel"

object TunnelService {

    suspend fun send(
        body: String = "",
        headers: Map<String, String> = mapOf(),
        host: String = "",
        method: String = "",
        params: Map<String, String> = mapOf(),
        path: String = "",
        url: String = ""
    ): TunnelResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Send")) {
            this.body = TunnelRequest(body, headers, host, method, params, path, url)
        }
    }
}
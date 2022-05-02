package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.TunnelRequest
import com.cyb3rko.m3okotlin.data.TunnelResponse
import io.ktor.client.request.*

private const val SERVICE = "tunnel"

/**
 * **Tunnel HTTP requests**
 *
 * Tunnel HTTP requests anywhere in the world through one endpoint. Build VPNs
 * or simple pass through proxies to bypass firewalls and restrictions.
 *
 * @since 0.1.0
 */
object TunnelService {

    /**
     * Send a request through the tunnel
     * @since 0.1.0
     */
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

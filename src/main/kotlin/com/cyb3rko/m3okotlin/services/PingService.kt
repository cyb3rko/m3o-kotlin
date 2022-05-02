package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "ping"

/**
 * **Ping any URL**
 *
 * Use ping to monitor services, check uptime and availability of any HTTP URL
 * or TCP endpoint.
 *
 * @since 0.1.0
 */
object PingService {

    /**
     * Ping an IP address
     * @since 0.1.0
     */
    suspend fun ip(address: String): PingIPResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ip")) {
            body = PingIPRequest(address)
        }
    }

    /**
     * Ping a TCP port is open
     * @since 0.1.0
     */
    suspend fun tcp(address: String, data: String = ""): PingTcpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Tcp")) {
            body = PingTcpRequest(address, data)
        }
    }

    /**
     * Ping a HTTP URL
     * @since 0.1.0
     */
    suspend fun url(address: String, method: String = ""): PingUrlResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Url")) {
            body = PingUrlRequest(address, method)
        }
    }
}

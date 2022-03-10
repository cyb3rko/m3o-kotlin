package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.PingIPRequest
import io.ktor.client.request.*

private const val SERVICE = "ping"

object PingService {

    suspend fun ip(address: String): PingIPResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Ip")) {
            body = PingIPRequest(address)
        }
    }

    suspend fun tcp(address: String, data: String = ""): PingTcpResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Tcp")) {
            body = PingTcpRequest(address, data)
        }
    }

    suspend fun url(address: String, method: String = ""): PingUrlResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Url")) {
            body = PingUrlRequest(address, method)
        }
    }
}
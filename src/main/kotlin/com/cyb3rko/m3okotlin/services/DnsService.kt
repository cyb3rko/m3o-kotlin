package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.DnsRequest
import com.cyb3rko.m3okotlin.data.DnsResponse
import io.ktor.client.request.*

private const val SERVICE = "dns"

/**
 * **DNS over HTTPS (DoH)**
 *
 * Query DNS over HTTPS with a single API call
 *
 * @since 0.1.0
 */
object DnsService {

    /**
     * Query an addresss
     * @since 0.1.0
     */
    suspend fun query(name: String, type: String = ""): DnsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Query")) {
            body = DnsRequest(name, type)
        }
    }
}

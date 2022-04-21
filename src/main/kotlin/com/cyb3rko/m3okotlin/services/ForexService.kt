package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "forex"

object ForexService {

    suspend fun history(symbol: String): ForexHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = ForexHistoryRequest(symbol)
        }
    }

    suspend fun price(symbol: String): ForexPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = ForexPriceRequest(symbol)
        }
    }

    suspend fun quote(symbol: String): ForexQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = ForexQuoteRequest(symbol)
        }
    }
}

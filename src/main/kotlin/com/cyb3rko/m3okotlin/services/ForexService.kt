package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "forex"

/**
 * **Foreign exchange (FX) rates**
 *
 * Real-time and historical foreign exchange (FX) rates for over 200 world
 * currencies. Get the latest rates and bid/ask prices.
 *
 * @since 0.1.0
 */
object ForexService {

    /**
     * Returns the data for the previous close
     * @since 0.1.0
     */
    suspend fun history(symbol: String): ForexHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = ForexHistoryRequest(symbol)
        }
    }

    /**
     * Get the latest price for a given forex ticker
     * @since 0.1.0
     */
    suspend fun price(symbol: String): ForexPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = ForexPriceRequest(symbol)
        }
    }

    /**
     * Get the latest quote for the forex
     * @since 0.1.0
     */
    suspend fun quote(symbol: String): ForexQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = ForexQuoteRequest(symbol)
        }
    }
}

package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "crypto"

/**
 * **Cryptocurrency prices, quotes, and news**
 *
 * Get up to the second cryptocurrency prices, quotes, previous close
 * information, and news.
 *
 * @since 0.1.0
 */
object CryptoService {

    /**
     * Returns the history for the previous close
     * @since 0.1.0
     */
    suspend fun history(symbol: String): CryptoHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = CryptoHistoryRequest(symbol)
        }
    }

    /**
     * Get news related to a currency
     * @since 0.1.0
     */
    suspend fun news(symbol: String): CryptoNewsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "News")) {
            body = CryptoNewsRequest(symbol)
        }
    }

    /**
     * Get the last price for a given crypto ticker
     * @since 0.1.0
     */
    suspend fun price(symbol: String): CryptoPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = CryptoPriceRequest(symbol)
        }
    }

    /**
     * Get the last quote for a given crypto ticker
     * @since 0.1.0
     */
    suspend fun quote(symbol: String): CryptoQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = CryptoQuoteRequest(symbol)
        }
    }

    /**
     * Returns the full list of supported symbols
     * @since 0.1.0
     */
    suspend fun symbols(): CryptoSymbolsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Symbols"))
    }
}

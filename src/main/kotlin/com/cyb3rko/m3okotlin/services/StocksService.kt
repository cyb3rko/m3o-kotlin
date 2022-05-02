package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "stock"

/**
 * **Live stock quotes and prices**
 *
 * Get live stock quotes and prices for thousands of US and global stocks.
 *
 * @since 0.1.0
 */
object StocksService {

    /**
     * Get the historic open-close for a given day
     * @since 0.1.0
     */
    suspend fun history(date: String, stock: String): StocksHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = StocksHistoryRequest(date, stock)
        }
    }

    /**
     * Get the last price for a given stock ticker
     * @since 0.1.0
     */
    suspend fun price(symbol: String): StocksPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = StocksPriceRequest(symbol)
        }
    }

    /**
     * Get the last quote for the stock
     * @since 0.1.0
     */
    suspend fun quote(symbol: String): StocksQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = StocksQuoteRequest(symbol)
        }
    }
}

package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "stock"

object StocksService {

    suspend fun history(date: String, stock: String): StocksHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = StocksHistoryRequest(date, stock)
        }
    }

    suspend fun price(symbol: String): StocksPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = StocksPriceRequest(symbol)
        }
    }

    suspend fun quote(symbol: String): StocksQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = StocksQuoteRequest(symbol)
        }
    }
}
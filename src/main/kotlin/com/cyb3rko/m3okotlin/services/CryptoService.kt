package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "crypto"

object CryptoService {

    suspend fun history(symbol: String): CryptoHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = CryptoHistoryRequest(symbol)
        }
    }

    suspend fun news(symbol: String): CryptoNewsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "News")) {
            body = CryptoNewsRequest(symbol)
        }
    }

    suspend fun price(symbol: String): CryptoPriceResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Price")) {
            body = CryptoPriceRequest(symbol)
        }
    }

    suspend fun quote(symbol: String): CryptoQuoteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Quote")) {
            body = CryptoQuoteRequest(symbol)
        }
    }

    suspend fun symbols(): CryptoSymbolsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Symbols"))
    }
}
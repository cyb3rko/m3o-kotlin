package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "price"

object PricesService {

    suspend fun add(
        author: String,
        currency: String,
        name: String,
        price: Double,
        source: String,
        symbol: String
    ): PricesAddResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Add")) {
            body = PricesAddRequest(author, currency, name, price, source, symbol)
        }
    }

    suspend fun get(
        currency: String,
        name: String = "",
        symbol: String = ""
    ): PricesGetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Get")) {
            body = PricesGetRequest(currency, name, symbol)
        }
    }

    suspend fun index(): PricesIndexResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Index"))
    }

    suspend fun list(
        currency: String,
        limit: Int = 0,
        offset: Int = 0
    ): PricesListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = PricesListRequest(currency, limit, offset)
        }
    }

    suspend fun report(
        comment: String,
        name: String = "",
        symbol: String = ""
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Report")) {
            body = PricesReportRequest(comment, name, symbol)
        }
    }
}

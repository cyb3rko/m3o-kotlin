package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "price"

/**
 * **Global commodities index**
 *
 * Get the price of global commodities like oil, gold, wheat and more. Commodity
 * prices are updated every 10-15 minutes. Add your own prices for anything not
 * already indexed.
 *
 * @since 0.1.0
 */
object PricesService {

    /**
     * Add a price
     * @since 0.1.0
     */
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

    /**
     * Get the price of anything
     * @since 0.1.0
     */
    suspend fun get(
        currency: String,
        name: String = "",
        symbol: String = ""
    ): PricesGetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Get")) {
            body = PricesGetRequest(currency, name, symbol)
        }
    }

    /**
     * Get the index for available prices
     * @since 0.1.0
     */
    suspend fun index(): PricesIndexResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Index"))
    }

    /**
     * List prices for a given currency
     * @since 0.1.0
     */
    suspend fun list(
        currency: String,
        limit: Int = 0,
        offset: Int = 0
    ): PricesListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = PricesListRequest(currency, limit, offset)
        }
    }

    /**
     * Report an invalid price
     * @since 0.1.0
     */
    suspend fun report(
        comment: String,
        name: String = "",
        symbol: String = ""
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Report")) {
            body = PricesReportRequest(comment, name, symbol)
        }
    }

    suspend fun PricesValue.add(
        author: String,
        price: Double,
        source: String
    ) = add(author, this.currency, this.name, price, source, this.symbol)

    suspend fun PricesValue.get(currency: String) = get(currency, this.name, this.symbol)

    suspend fun PricesValue.report(comment: String) = report(comment, this.name, this.symbol)

    suspend fun PricesIndex.add(
        author: String,
        price: Double,
        source: String
    ) = add(author, this.currency, this.name, price, source, this.symbol)

    suspend fun PricesIndex.get(currency: String) = get(currency, this.name, this.symbol)

    suspend fun PricesIndex.report(comment: String) = report(comment, this.name, this.symbol)
}

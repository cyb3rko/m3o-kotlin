package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.CurrencyCodesResponse.CurrencyCode
import io.ktor.client.request.*

private const val SERVICE = "currency"

/**
 * **Exchange rates and currency conversion**
 *
 * Real time currency conversion and exchange rates. Rate updates occur every 5
 * minutes.
 *
 * @since 0.1.0
 */
object CurrencyService {

    /**
     * Codes returns the supported currency codes for the API
     * @since 0.1.0
     */
    suspend fun codes(): CurrencyCodesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Codes"))
    }

    /**
     * Convert returns the currency conversion rate between two pairs e.g
     * USD/GBP
     * @since 0.1.0
     */
    suspend fun convert(
        amount: Float,
        from: String,
        to: String
    ): CurrencyConvertResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Convert")) {
            body = CurrencyConvertRequest(amount, from, to)
        }
    }

    /**
     * Returns the historic rates for a currency on a given date
     * @since 0.1.0
     */
    suspend fun history(code: String, date: String): CurrencyHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = CurrencyHistoryRequest(code, date)
        }
    }

    /**
     * Rates returns the currency rates for a given code e.g USD
     * @since 0.1.0
     */
    suspend fun rates(code: String): CurrencyRatesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Rates")) {
            body = CurrencyRatesRequest(code)
        }
    }

    suspend fun CurrencyCode.convert(amount: Float, to: String) = convert(amount, this.name, to)

    suspend fun CurrencyCode.history(date: String) = history(this.name, date)

    suspend fun CurrencyCode.rates() = rates(this.name)
}

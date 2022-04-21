package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "currency"

object CurrencyService {

    suspend fun codes(): CurrencyCodesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Codes"))
    }

    suspend fun convert(
        amount: Float,
        from: String,
        to: String
    ): CurrencyConvertResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Convert")) {
            body = CurrencyConvertRequest(amount, from, to)
        }
    }

    suspend fun history(code: String, date: String): CurrencyHistoryResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "History")) {
            body = CurrencyHistoryRequest(code, date)
        }
    }

    suspend fun rates(code: String): CurrencyRatesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Rates")) {
            body = CurrencyRatesRequest(code)
        }
    }
}

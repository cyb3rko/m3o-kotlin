package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
data class CurrencyCodesResponse(val codes: List<CurrencyCode>) {

    @Serializable
    data class CurrencyCode(val currency: String, val name: String)
}

@Serializable
internal data class CurrencyConvertRequest(
    val amount: Float,
    val from: String,
    val to: String
)

@Serializable
data class CurrencyConvertResponse(
    val amount: Float,
    val from: String,
    val rate: Float,
    val to: String
)

@Serializable
internal data class CurrencyHistoryRequest(val code: String, val date: String)

@Serializable
data class CurrencyHistoryResponse(
    val code: String,
    val date: String,
    val rates: Map<String, Float>
)

@Serializable
internal data class CurrencyRatesRequest(val code: String)

@Serializable
data class CurrencyRatesResponse(val code: String, val rates: Map<String, Float>)

package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class CryptoHistoryRequest(val symbol: String)

@Serializable
data class CryptoHistoryResponse(
    val close: Float,
    val date: String,
    val high: Float,
    val low: Float,
    val open: Float,
    val symbol: String,
    val volume: Double
)

@Serializable
internal data class CryptoNewsRequest(val symbol: String)

@Serializable
data class CryptoNewsResponse(val articles: List<CryptoNewsArticle>, val symbol: String) {

    @Serializable
    data class CryptoNewsArticle(
        val date: String,
        val description: String,
        val source: String,
        val title: String,
        val url: String
    )
}

@Serializable
internal data class CryptoPriceRequest(val symbol: String)

@Serializable
data class CryptoPriceResponse(val price: Float, val symbol: String)

@Serializable
internal data class CryptoQuoteRequest(val symbol: String)

@Serializable
data class CryptoQuoteResponse(
    @SerialName("ask_price")
    val askPrice: Float,
    @SerialName("ask_size")
    val askSize: Double,
    @SerialName("bid_price")
    val bidPrice: Float,
    @SerialName("bid_size")
    val bidSize: Double,
    val symbol: String,
    val timestamp: String
)

@Serializable
data class CryptoSymbolsResponse(val symbols: List<CryptoSymbolsEntry>) {

    @Serializable
    data class CryptoSymbolsEntry(val name: String, val symbol: String)
}
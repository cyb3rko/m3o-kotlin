package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class ForexHistoryRequest(val symbol: String)

@Serializable
data class ForexHistoryResponse(
    val close: Float,
    val date: String,
    val high: Float,
    val low: Float,
    val open: Float,
    val symbol: String,
    val volume: Int
)

@Serializable
internal data class ForexPriceRequest(val symbol: String)

@Serializable
data class ForexPriceResponse(val price: Float, val symbol: String)

@Serializable
internal data class ForexQuoteRequest(val symbol: String)

@Serializable
data class ForexQuoteResponse(
    @SerialName("ask_price")
    val askPrice: Float,
    @SerialName("bid_price")
    val bidPrice: Float,
    val symbol: String,
    val timestamp: String
)

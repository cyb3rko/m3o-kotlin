package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class StocksHistoryRequest(val date: String, val stock: String)

@Serializable
data class StocksHistoryResponse(
    val close: Float,
    val date: String,
    val high: Float,
    val low: Float,
    val open: Float,
    val symbol: String,
    val volume: Int
)

@Serializable
internal data class StocksPriceRequest(val symbol: String)

@Serializable
data class StocksPriceResponse(val price: Float, val symbol: String)

@Serializable
internal data class StocksQuoteRequest(val symbol: String)

@Serializable
data class StocksQuoteResponse(
    @SerialName("ask_price")
    val askPrice: Float,
    @SerialName("bid_price")
    val bidPrice: Float,
    @SerialName("ask_size")
    val askSize: Int,
    @SerialName("bid_size")
    val bidSize: Int,
    val symbol: String,
    val timestamp: String
)
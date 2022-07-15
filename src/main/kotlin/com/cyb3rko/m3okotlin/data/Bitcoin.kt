package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class BitcoinBalanceRequest(val address: String)

@Serializable
data class BitcoinBalanceResponse(val balance: String)

@Serializable
internal data class BitcoinPriceRequest(val symbol: String)

@Serializable
data class BitcoinPriceResponse(val price: Float, val symbol: String)

package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class BitcoinRequest(val symbol: String)

@Serializable
data class BitcoinResponse(val price: Float, val symbol: String)

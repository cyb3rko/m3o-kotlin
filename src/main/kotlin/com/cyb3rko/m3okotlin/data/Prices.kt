package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class PricesAddRequest(
    val author: String,
    val currency: String,
    val name: String,
    val price: Double,
    val source: String,
    val symbol: String
)

@Serializable
data class PricesAddResponse(val value: PricesValue)

@Serializable
internal data class PricesGetRequest(
    val currency: String,
    val name: String,
    val symbol: String
)

@Serializable
data class PricesGetResponse(val values: List<PricesValue>)

@Serializable
data class PricesIndexResponse(val index: List<PricesIndex>)

@Serializable
internal data class PricesListRequest(
    val currency: String,
    val limit: Int,
    val offset: Int
)

@Serializable
data class PricesListResponse(val values: List<PricesValue>)

@Serializable
internal data class PricesReportRequest(
    val comment: String,
    val name: String,
    val symbol: String
)

// Data (multiple use)

@Serializable
data class PricesIndex(
    val currency: String,
    val name: String,
    val symbol: String
)

@Serializable
data class PricesValue(
    val author: String,
    val currency: String,
    val name: String,
    val price: Double,
    val source: String,
    val symbol: String,
    val timestamp: String
)

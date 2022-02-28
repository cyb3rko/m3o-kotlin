package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class IP2GeoRequest(val ip: String)

@Serializable
data class IP2GeoResponse(
    val asn: Int,
    val city: String,
    val continent: String,
    val country: String,
    val ip: String,
    val latitude: Float,
    val longitude: Float,
    val timezone: String
)
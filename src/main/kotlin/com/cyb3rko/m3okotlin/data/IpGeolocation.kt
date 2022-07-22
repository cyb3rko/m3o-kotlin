package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class IpGeolocationRequest(val ip: String)

@Serializable
data class IpGeolocationResponse(
    val asn: Int? = null,
    val city: String? = null,
    val continent: String,
    val country: String,
    val ip: String,
    val latitude: Float,
    val longitude: Float,
    val timezone: String
)

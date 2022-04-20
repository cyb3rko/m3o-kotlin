package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class GeocodingLookupRequest(
    val address: String,
    val city: String,
    val country: String,
    val postcode: String
)

@Serializable
data class GeocodingLookupResponse(val address: GeocodingAddress, val location: GeocodingLocation)

@Serializable
internal data class GeocodingReverseRequest(val latitude: Double, val longitude: Double)

@Serializable
data class GeocodingReverseResponse(val address: GeocodingAddress, val location: GeocodingLocation)

// Data (multiple use)

@Serializable
data class GeocodingAddress(
    val city: String,
    val country: String,
    @SerialName("line_one")
    val lineOne: String,
    val postcode: String
)

@Serializable
data class GeocodingLocation(val latitude: Double, val longitude: Double)
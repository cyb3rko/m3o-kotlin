package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class PlacesNearbyRequest(
    val keyword: String,
    val location: String,
    val name: String,
    @SerialName("open_now")
    val openNow: Boolean,
    val radius: Int,
    val type: String
)

@Serializable
data class PlacesNearbyResponse(val results: List<Place>)

@Serializable
internal data class PlacesSearchRequest(
    val location: String,
    @SerialName("open_now")
    val openNow: Boolean,
    val query: String,
    val radius: Int,
    val type: String
)

@Serializable
data class PlacesSearchResponse(val results: List<Place>)

// Data (multiple use)

@Serializable
data class Place(
    val address: String,
    @SerialName("icon_url")
    val iconUrl: String,
    val location: String,
    val name: String,
    @SerialName("open_now")
    val openNow: Boolean,
    @SerialName("opening_hours")
    val openingHours: List<String>,
    val rating: Double,
    val type: String,
    val types: List<String>,
    val vicinity: String
)

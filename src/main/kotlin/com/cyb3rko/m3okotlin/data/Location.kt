package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class LocationReadRequest(val id: String)

@Serializable
data class LocationReadResponse(val entity: Location)

@Serializable
internal data class LocationSaveRequest(val entity: Location)

@Serializable
internal data class LocationSearchRequest(
    val center: LocationCoordinates,
    val numEntities: Int,
    val radius: Int,
    val type: String
)

@Serializable
data class Location(
    val id: String,
    val location: LocationDetails,
    val type: String
)

@Serializable
data class LocationDetails(
    val latitude: Double,
    val longitude: Double,
    val timestamp: Int
)

@Serializable
data class LocationCoordinates(val latitude: Double, val longitude: Double)

@Serializable
data class LocationSearchResponse(val entities: List<Location>)
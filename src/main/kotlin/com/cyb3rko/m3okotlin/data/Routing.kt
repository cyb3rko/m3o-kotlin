package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class RoutingDirectionsRequest(val destination: RoutingCoordinates, val origin: RoutingCoordinates)

@Serializable
data class RoutingDirectionsResponse(
    val directions: List<RoutingDirection>,
    val distance: Double,
    val duration: Double,
    val waypoints: List<RoutingWaypoint>
) {

    @Serializable
    data class RoutingDirection(
        val distance: Double? = null,
        val duration: Double? = null,
        val instruction: String,
        val intersections: List<RoutingIntersection>,
        val maneuver: RoutingManeuver,
        val name: String,
    ) {

        @Serializable
        data class RoutingIntersection(
            val location: RoutingCoordinates,
            val bearings: List<Int>
        )

        @Serializable
        data class RoutingManeuver(
            val action: String,
            @SerialName("bearing_after")
            val bearingAfter: Int? = null,
            @SerialName("bearing_before")
            val bearingBefore: Int? = null,
            val direction: String? = null,
            val location: RoutingCoordinates
        )
    }
}

@Serializable
internal data class RoutingEtaRequest(
    val destination: RoutingCoordinates,
    val origin: RoutingCoordinates,
    val speed: Int,
    val type: String
)

@Serializable
data class RoutingEtaResponse(val duration: Double)

@Serializable
internal data class RoutingRouteRequest(val destination: RoutingCoordinates, val origin: RoutingCoordinates)

@Serializable
data class RoutingRouteResponse(
    val distance: Double,
    val duration: Double,
    val waypoints: List<RoutingWaypoint>
)

// Data (multiple use)

@Serializable
data class RoutingCoordinates(val latitude: Double, val longitude: Double)

@Serializable
data class RoutingWaypoint(val name: String, val location: RoutingCoordinates)
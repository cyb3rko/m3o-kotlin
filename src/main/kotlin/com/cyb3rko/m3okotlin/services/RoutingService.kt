package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "routing"

/**
 * **Etas, routes and turn by turn directions**
 *
 * A simpler, faster and cheaper alternative to the Google Maps API. Get etas,
 * routes, and turn by turn directions all from OpenStreetMap data.
 *
 * @since 0.1.0
 */
object RoutingService {

    /**
     * Turn by turn directions from a start point to an end point including
     * maneuvers and bearings
     * @since 0.1.0
     */
    suspend fun directions(destination: RoutingCoordinates, origin: RoutingCoordinates): RoutingDirectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Directions")) {
            body = RoutingDirectionsRequest(destination, origin)
        }
    }

    /**
     * Get the eta for a route from origin to destination. The eta is an
     * estimated time based on car routes
     * @since 0.1.0
     */
    suspend fun eta(
        destination: RoutingCoordinates,
        origin: RoutingCoordinates,
        speed: Int = 0,
        type: String = "car"
    ): RoutingEtaResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Eta")) {
            body = RoutingEtaRequest(destination, origin, speed, type)
        }
    }

    /**
     * Retrieve a route as a simple list of gps points along with total distance
     * and estimated duration
     * @since 0.1.0
     */
    suspend fun route(destination: RoutingCoordinates, origin: RoutingCoordinates): RoutingRouteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Route")) {
            body = RoutingRouteRequest(destination, origin)
        }
    }
}

package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "routing"

object RoutingService {

    suspend fun directions(destination: RoutingCoordinates, origin: RoutingCoordinates): RoutingDirectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Directions")) {
            body = RoutingDirectionsRequest(destination, origin)
        }
    }

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

    suspend fun route(destination: RoutingCoordinates, origin: RoutingCoordinates): RoutingRouteResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Route")) {
            body = RoutingRouteRequest(destination, origin)
        }
    }
}
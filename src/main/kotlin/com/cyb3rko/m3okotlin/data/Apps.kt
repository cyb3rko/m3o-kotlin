package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Requests & Responses + Data (single use)

@Serializable
internal data class AppsDeleteRequest(val name: String)

@Serializable
data class AppsListResponse(val services: List<AppsService>)

@Serializable
internal data class AppsLogsRequest(
    @SerialName("logs_type")
    val logsType: String,
    val name: String
)

@Serializable
data class AppsLogsResponse(val logs: String)

@Serializable
data class AppsRegionsResponse(val regions: List<String>)

@Serializable
internal data class AppsReserveRequest(val name: String)

@Serializable
data class AppsReserveResponse(val reservation: AppsReservation) {

    @Serializable
    data class AppsReservation(
        val created: String,
        val expires: String,
        val name: String,
        val owner: String,
        val token: String
    )
}

@Serializable
internal data class AppsResolveRequest(val id: String)

@Serializable
data class AppsResolveResponse(val url: String)

@Serializable
internal data class AppsRunRequest(
    val branch: String,
    @SerialName("env_vars")
    val envVars: Map<String, String>,
    val name: String,
    val port: Int,
    val region: String,
    val repo: String
)

@Serializable
data class AppsRunResponse(val service: AppsService)

@Serializable
internal data class AppsStatusRequest(val name: String)

@Serializable
data class AppsStatusResponse(val service: AppsService)

@Serializable
internal data class AppsUpdateRequest(
    @SerialName("env_vars")
    val envVars: Map<String, String>,
    val name: String
)

// Data (multiple use)

@Serializable
data class AppsService(
    val branch: String,
    val created: String,
    @SerialName("custom_domains")
    val customDomains: List<String>,
    @SerialName("env_vars")
    val envVars: Map<String, String>,
    val id: String,
    val name: String,
    val port: Int,
    val region: String,
    val repo: String,
    val status: String,
    val updated: String,
    val url: String,
)

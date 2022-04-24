package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject

// Requests & Responses + Data (single use)

@Serializable
internal data class FunctionsCallRequest(val name: String, val request: JsonObject)

@Serializable
data class FunctionsCallResponse(val response: JsonObject)

@Serializable
internal data class FunctionsDeleteRequest(val name: String)

@Serializable
internal data class FunctionsDeployRequest(
    val branch: String,
    val entrypoint: String,
    @SerialName("env_vars")
    val envVars: JsonObject,
    val name: String,
    val region: String,
    val repo: String,
    val runtime: String,
    val source: String,
    val subfolder: String
)

@Serializable
data class FunctionsDeployResponse(val function: FunctionsFunction)

@Serializable
internal data class FunctionsDescribeRequest(val name: String)

@Serializable
data class FunctionsDescribeResponse(val function: FunctionsFunction)

@Serializable
data class FunctionsListResponse(val functions: List<FunctionsFunction>)

@Serializable
internal data class FunctionsLogsRequest(
    @SerialName("logs_type")
    val logsType: String,
    val name: String
)

@Serializable
data class FunctionsLogsResponse(val logs: String)

@Serializable
internal data class FunctionsProxyRequest(val id: String)

@Serializable
data class FunctionsProxyResponse(val url: String)

@Serializable
data class FunctionsRegionsResponse(val regions: List<String>)

@Serializable
internal data class FunctionsReserveRequest(val name: String)

@Serializable
data class FunctionsReserveResponse(val reservation: FunctionsReservation) {

    @Serializable
    data class FunctionsReservation(
        val created: String,
        val expires: String,
        val name: String,
        val owner: String,
        val token: String
    )
}

@Serializable
data class FunctionsRuntimesResponse(val runtimes: List<String>)

@Serializable
internal data class FunctionsUpdateRequest(val name: String, val source: String)

// Data (multiple use)

@Serializable
data class FunctionsFunction(
    val branch: String,
    val created: String,
    val entrypoint: String,
    @SerialName("env_vars")
    val envVars: JsonObject,
    val id: String,
    val name: String,
    val region: String,
    val repo: String,
    val runtime: String,
    val status: String,
    val subfolder: String,
    val updated: String,
    val url: String
)

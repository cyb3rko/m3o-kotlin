package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class TunnelRequest(
    val body: String,
    val headers: Map<String, String>,
    val host: String,
    val method: String,
    val params: Map<String, String>,
    val path : String,
    val url: String
)

@Serializable
data class TunnelResponse(
    val body: String,
    val headers: Map<String, String>,
    val status: String,
    @SerialName("status_code")
    val statusCode: Int
)

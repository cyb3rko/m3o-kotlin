package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PingIPRequest(val address: String)

@Serializable
data class PingIPResponse(val latency: String, val status: String)

@Serializable
internal data class PingTcpRequest(val address: String, val data: String)

@Serializable
data class PingTcpResponse(val data: String? = null, val status: String)

@Serializable
internal data class PingUrlRequest(val address: String, val data: String)

@Serializable
data class PingUrlResponse(val code: Int, val status: String)

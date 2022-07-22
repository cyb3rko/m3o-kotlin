package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class IdGenerateRequest(val type: String)

@Serializable
data class IdGenerateResponse(val id: String, val type: String)

@Serializable
data class IdTypesResponse(val types: List<String>)

package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class IDGenerateRequest(val type: String)

@Serializable
data class IDGenerateResponse(val id: String, val type: String)

@Serializable
data class IDTypesResponse(val types: List<String>)
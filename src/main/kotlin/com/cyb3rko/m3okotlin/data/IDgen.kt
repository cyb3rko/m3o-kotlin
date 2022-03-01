package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class IDgenGenerateRequest(val type: String)

@Serializable
data class IDgenGenerateResponse(val id: String, val type: String)

@Serializable
data class IDgenTypesResponse(val types: List<String>)
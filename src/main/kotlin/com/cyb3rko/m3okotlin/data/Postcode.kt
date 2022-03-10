package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PostcodeLookupRequest(val postcode: String)

@Serializable
data class PostcodeLookupResponse(
    val country: String,
    val district: String,
    val latitude: Float,
    val longitude: Float,
    val postcode: String,
    val region: String,
    val ward: String
)
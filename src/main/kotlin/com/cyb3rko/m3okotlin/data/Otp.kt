package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class OtpGenerateRequest(
    val expiry: Int,
    val id: String,
    val size: Int
)

@Serializable
data class OtpGenerateResponse(val code: String)

@Serializable
internal data class OtpValidateRequest(val code: String, val id: String)

@Serializable
data class OtpValidateResponse(val success: Boolean)

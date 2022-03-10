package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class OTPGenerateRequest(
    val expiry: Int,
    val id: String,
    val size: Int
)

@Serializable
data class OTPGenerateResponse(val code: String)

@Serializable
internal data class OTPValidateRequest(val code: String, val id: String)

@Serializable
data class OTPValidateResponse(val success: Boolean)
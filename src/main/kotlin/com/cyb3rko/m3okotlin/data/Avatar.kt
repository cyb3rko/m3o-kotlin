package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class AvatarRequest(
    val format: String,
    val gender: String,
    val upload: Boolean,
    val username: String
)

@Serializable
data class AvatarResponse(
    val base64: String,
    val url: String
)

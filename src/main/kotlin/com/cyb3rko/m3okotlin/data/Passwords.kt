package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class PasswordsRequest(
    val length: Int,
    val lowercase: Boolean,
    val numbers: Boolean,
    val special: Boolean,
    val uppercase: Boolean
)

@Serializable
data class PasswordsResponse(val password: String)
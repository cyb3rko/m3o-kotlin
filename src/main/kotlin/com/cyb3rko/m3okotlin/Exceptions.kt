package com.cyb3rko.m3okotlin

import kotlinx.serialization.Serializable

class InvalidParameterException(message: String) : Exception(message)

@Serializable
data class CustomError(
    val code: Int,
    val detail: String,
    val id: String,
    val status: String
)

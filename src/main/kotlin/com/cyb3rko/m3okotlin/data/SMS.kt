package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class SMSRequest(val from: String, val message: String, val to: String)

@Serializable
data class SMSResponse(val info: String? = null, val status: String)
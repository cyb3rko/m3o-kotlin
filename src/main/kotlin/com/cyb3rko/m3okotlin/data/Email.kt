package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class EmailParseRequest(val address: String)

@Serializable
data class EmailParseResponse(val address: String, val name: String)

@Serializable
internal data class EmailSendRequest(
    val from: String,
    @SerialName("html_body")
    val htmlBody: String,
    @SerialName("reply_to")
    val replyTo: String,
    val subject: String,
    @SerialName("text_body")
    val textBody: String,
    val to: String
)

@Serializable
internal data class EmailValidateRequest(val address: String)

@Serializable
data class EmailValidateResponse(@SerialName("is_valid") val isValid: Boolean)

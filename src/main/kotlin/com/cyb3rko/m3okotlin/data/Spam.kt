package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class SpamRequest(
    @SerialName("email_body")
    val emailBody: String,
    val from: String,
    @SerialName("html_body")
    val htmlBody: String,
    val subject: String,
    @SerialName("text_body")
    val textBody: String,
    val to: String
)

@Serializable
data class SpamResponse(
    val details: List<String>,
    @SerialName("is_spam")
    val isSpam: Boolean,
    val score: Float
)

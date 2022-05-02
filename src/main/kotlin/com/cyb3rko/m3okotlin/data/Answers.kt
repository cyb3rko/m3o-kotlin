package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class AnswersRequest(val query: String)

@Serializable
data class AnswersResponse(
    val answer: String,
    val image: String,
    val url: String
)

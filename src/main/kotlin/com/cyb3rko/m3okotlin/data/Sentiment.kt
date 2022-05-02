package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class SentimentRequest(val lang: String, val text: String)

@Serializable
data class SentimentResponse(val score: Int)

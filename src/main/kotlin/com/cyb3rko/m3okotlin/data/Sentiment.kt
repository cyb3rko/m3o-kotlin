package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class SentimentRequest(val text: String, val lang: String)

@Serializable
data class SentimentResponse(val score: Int)
package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class TranslateRequest(
    val content: String,
    val format: String,
    val model: String,
    val source: String,
    val target: String
)

@Serializable
data class TranslateResponse(val translation: Translation) {

    @Serializable
    data class Translation(
        val model: String,
        val source: String,
        val text: String
    )
}

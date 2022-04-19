package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class MemegenGenerateRequest(
    @SerialName("bottom_text")
    val bottomText: String,
    val font: String,
    val id: String,
    @SerialName("max_font_size")
    val maxFontSize: String,
    @SerialName("top_text")
    val topText: String
)

@Serializable
data class MemegenGenerateResponse(val url: String)

@Serializable
data class MemegenTemplatesResponse(val templates: List<MemegenTemplatesEntry>) {

    @Serializable
    data class MemegenTemplatesEntry(
        val id: String,
        val name: String,
        val url: String,
        val width: Int,
        val height: Int,
        @SerialName("box_count")
        val boxCount: Int
    )
}
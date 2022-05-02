package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
internal data class GoogleRequest(val query: String)

@Serializable
data class GoogleResponse(val results: List<GoogleSearchResult>) {

    @Serializable
    data class GoogleSearchResult(
        @SerialName("display_url")
        val displayUrl: String,
        val id: String,
        val kind: String,
        val snippet: String,
        val title: String,
        val url: String
    )
}

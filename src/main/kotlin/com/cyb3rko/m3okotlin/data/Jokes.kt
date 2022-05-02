package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class JokesRequest(val count: Int)

@Serializable
data class JokesResponse(val jokes: List<Joke>) {

    @Serializable
    data class Joke(
        val body: String,
        val category: String,
        val id: String,
        val source: String,
        val title: String
    )
}

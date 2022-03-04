package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class ThumbnailRequest(val height: Int, val url: String, val width: Int)

@Serializable
data class ThumbnailResponse(val imageURL: String)
package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class EmojiFindRequest(val alias: String)

@Serializable
data class EmojiFindResponse(val emoji: String)

@Serializable
internal data class EmojiFlagRequest(val code: String)

@Serializable
data class EmojiFlagResponse(val flag: String)

@Serializable
internal data class EmojiPrintRequest(val text: String)

@Serializable
data class EmojiPrintResponse(val text: String)
package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class MQPublishRequest(
    val message: MQMessage,
    val topic: String
)

@Serializable
data class MQMessage(
    val id: String,
    val type: String,
    val user: String
)

@Serializable
internal data class MQSubscribeRequest(val topic: String)

@Serializable
data class MQSubscribeResponse(
    val message: MQMessage,
    val topic: String
)
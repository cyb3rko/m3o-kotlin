package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class MqPublishRequest(val message: MqMessage, val topic: String)

@Serializable
data class MqMessage(
    val id: String,
    val type: String,
    val user: String
)

@Serializable
internal data class MqSubscribeRequest(val topic: String)

@Serializable
data class MqSubscribeResponse(val message: MqMessage, val topic: String)

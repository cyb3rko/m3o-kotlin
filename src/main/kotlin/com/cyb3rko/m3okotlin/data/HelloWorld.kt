package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.Serializable

@Serializable
internal data class HelloWorldCallRequest(val name: String)

@Serializable
data class HelloWorldCallResponse(val message: String)

@Serializable
internal data class HelloWorldStreamRequest(val name: String, val messages: Int)

@Serializable
data class HelloWorldStreamResponse(val message: String)
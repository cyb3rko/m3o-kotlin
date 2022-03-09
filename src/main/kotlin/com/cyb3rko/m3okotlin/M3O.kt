package com.cyb3rko.m3okotlin

import io.ktor.client.*
import io.ktor.client.engine.apache.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.features.websocket.*
import io.ktor.client.request.*
import io.ktor.http.*

object M3O {
    private const val BASE_URL = "https://api.m3o.com/v1"
    private const val BASE_URL_STREAM = "wss://api.m3o.com/v1"
    internal lateinit var authorization: Pair<String, String>
    internal lateinit var ktorHttpClient: HttpClient

    fun initialize(apiKey: String) {
        Log.initialize()
        Log.i("Initializing Ktor M3O Client...")

        if (!Regex("[a-zA-Z0-9]+").matches(apiKey) || apiKey.length > 64) {
            throw InvalidParameterException("The M3O API Key contains invalid characters or does not have 48 characters.")
        }

        authorization = "Authorization" to "Bearer $apiKey"

        ktorHttpClient = HttpClient(Apache) {
            install(JsonFeature) {
                serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                    prettyPrint = true
                })
            }

            install(WebSockets)

            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json)
                header(HttpHeaders.Authorization, authorization.second)
            }

            // Logging for debugging

//            install(Logging) {
//                logger = object : Logger {
//                    override fun log(message: String) {
//                        Log.i("Logger Ktor => $message")
//                    }
//
//                }
//                level = LogLevel.ALL
//            }
        }

        Log.i("Ktor M3O Client initialized.")
    }

    fun getUrl(service: String, endpoint: String, stream: Boolean = false): String {
        val url = if (!stream) BASE_URL else BASE_URL_STREAM
        return "$url/$service/$endpoint"
    }
}
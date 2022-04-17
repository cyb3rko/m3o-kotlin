package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "url"

object URLsService {

    suspend fun list(shortURL: String = ""): URLsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List")) {
            body = URLsListRequest(shortURL)
        }
    }

    suspend fun proxy(shortURL: String): URLsProxyResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Proxy")) {
            body = URLsProxyRequest(shortURL)
        }
    }

    suspend fun shorten(destinationURL: String): URLsShortenResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Shorten")) {
            body = URLsShortenRequest(destinationURL)
        }
    }
}
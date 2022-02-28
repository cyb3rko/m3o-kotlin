package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AnswersRequest
import com.cyb3rko.m3okotlin.data.AnswersResponse
import io.ktor.client.request.*

private const val SERVICE = "answer"

object AnswersService {

    suspend fun question(query: String): AnswersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Question")) {
            body = AnswersRequest(query)
        }
    }
}
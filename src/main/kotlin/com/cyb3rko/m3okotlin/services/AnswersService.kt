package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.AnswersRequest
import com.cyb3rko.m3okotlin.data.AnswersResponse
import io.ktor.client.request.*

private const val SERVICE = "answer"

/**
 * **Instant answers to any question**
 *
 * Ask a question and get an instant answer.
 *
 * @since 0.1.0
 */
object AnswersService {

    /**
     * Ask a question and receive an instant answer
     * @since 0.1.0
     */
    suspend fun question(query: String): AnswersResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Question")) {
            body = AnswersRequest(query)
        }
    }
}

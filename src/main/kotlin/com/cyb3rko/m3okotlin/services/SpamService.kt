package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.SpamRequest
import com.cyb3rko.m3okotlin.data.SpamResponse
import io.ktor.client.request.*

private const val SERVICE = "spam"

object SpamService {

    suspend fun classify(
        emailBody: String = "",
        from: String = "",
        htmlBody: String = "",
        subject: String = "",
        textBody: String = "",
        to: String = "",
    ): SpamResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Classify")) {
            this.body = SpamRequest(emailBody, from, htmlBody, subject, textBody, to)
        }
    }
}

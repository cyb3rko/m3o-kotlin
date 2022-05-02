package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.SpamRequest
import com.cyb3rko.m3okotlin.data.SpamResponse
import io.ktor.client.request.*

private const val SERVICE = "spam"

/**
 * **Check if an email is spam**
 *
 * An API to classify emails against spam detection rules.
 *
 * @since 0.1.0
 */
object SpamService {

    /**
     * Check whether an email is likely to be spam based on its attributes
     * @since 0.1.0
     */
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

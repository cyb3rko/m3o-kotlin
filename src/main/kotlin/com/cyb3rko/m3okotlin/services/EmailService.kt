package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "email"

/**
 * **Send emails in a flash**
 *
 * A quick and easy email API. Simply provide a from, to, and text or html body.
 *
 * @since 0.1.0
 */
object EmailService {

    /**
     * Parse an RFC5322 address e.g "Joe Blogs <joe@example.com>"
     * @since 0.1.0
     */
    suspend fun parse(address: String): EmailParseResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Parse")) {
            body = EmailParseRequest(address)
        }
    }

    /**
     * Send an email by passing in from, to, subject, and a text or html body
     * @since 0.1.0
     */
    suspend fun send(
        from: String,
        subject: String,
        to: String,
        htmlBody: String = "",
        replyTo: String = "",
        textBody: String = "",
    ) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Send")) {
            body = EmailSendRequest(from, htmlBody, replyTo, subject, textBody, to)
        }
    }

    /**
     * Validate an email address format
     * @since 0.1.0
     */
    suspend fun validate(address: String): EmailValidateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Validate")) {
            body = EmailValidateRequest(address)
        }
    }
}

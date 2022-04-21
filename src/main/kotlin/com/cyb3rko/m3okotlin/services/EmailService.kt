package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "email"

object EmailService {

    suspend fun parse(address: String): EmailParseResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Parse")) {
            body = EmailParseRequest(address)
        }
    }

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

    suspend fun validate(address: String): EmailValidateResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Validate")) {
            body = EmailValidateRequest(address)
        }
    }
}
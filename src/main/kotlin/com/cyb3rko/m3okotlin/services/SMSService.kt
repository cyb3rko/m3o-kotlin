package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.SMSRequest
import com.cyb3rko.m3okotlin.data.SMSResponse
import io.ktor.client.request.*

private const val SERVICE = "sms"

/**
 * **Send SMS messages**
 *
 * Send SMS messages in seconds. Integrate into any product for verification
 * codes, links, reminders and more.
 *
 * @since 0.1.0
 */
object SMSService {

    /**
     * Send an SMS.
     * @since 0.1.0
     */
    suspend fun send(from: String, message: String, to: String): SMSResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Send")) {
            body = SMSRequest(from, message, to)
        }
    }
}

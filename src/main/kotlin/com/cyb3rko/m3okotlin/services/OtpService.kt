package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.OtpGenerateRequest
import com.cyb3rko.m3okotlin.data.OtpGenerateResponse
import com.cyb3rko.m3okotlin.data.OtpValidateRequest
import com.cyb3rko.m3okotlin.data.OtpValidateResponse
import io.ktor.client.request.*

private const val SERVICE = "otp"

/**
 * **One time password generation**
 *
 * Generate one time passwords (OTP) for any unique id, email, or user. Codes
 * have a user configurable expiry time.
 *
 * @since 0.1.0
 */
object OtpService {

    /**
     * Generate an OTP (one time pass) code
     * @since 0.1.0
     */
    suspend fun generate(
        id: String,
        size: Int = 6,
        expiry: Int = 60
    ): OtpGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = OtpGenerateRequest(expiry, id, size)
        }
    }

    /**
     * Validate the OTP code
     * @since 0.1.0
     */
    suspend fun validate(id: String, code: String): OtpValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
            body = OtpValidateRequest(code, id)
        }
    }
}

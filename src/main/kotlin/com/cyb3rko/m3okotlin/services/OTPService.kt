package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O.getUrl
import com.cyb3rko.m3okotlin.M3O.ktorHttpClient
import com.cyb3rko.m3okotlin.data.OTPGenerateRequest
import com.cyb3rko.m3okotlin.data.OTPGenerateResponse
import com.cyb3rko.m3okotlin.data.OTPValidateRequest
import com.cyb3rko.m3okotlin.data.OTPValidateResponse
import io.ktor.client.request.*

private const val SERVICE = "otp"

object OTPService {

    suspend fun generate(id: String, size: Int = 6, expiry: Int = 60): OTPGenerateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Generate")) {
          body = OTPGenerateRequest(expiry, id, size)
        }
    }

    suspend fun validate(id: String, code: String): OTPValidateResponse {
        return ktorHttpClient.post(getUrl(SERVICE, "Validate")) {
            body = OTPValidateRequest(code, id)
        }
    }
}
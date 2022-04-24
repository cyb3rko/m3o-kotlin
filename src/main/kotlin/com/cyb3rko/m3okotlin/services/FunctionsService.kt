package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "function"

object FunctionsService {

    suspend fun call(name: String, request: JsonObject): FunctionsCallResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Call")) {
            body = FunctionsCallRequest(name, request)
        }
    }

    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = FunctionsDeleteRequest(name)
        }
    }

    suspend fun deploy(
        name: String,
        repo: String,
        runtime: String,
        branch: String = "master",
        entrypoint: String = name,
        envVars: JsonObject = JsonObject(mapOf()),
        region: String = "europe-west1",
        source: String = "",
        subfolder: String = ""
    ): FunctionsDeployResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Deploy")) {
            body = FunctionsDeployRequest(branch, entrypoint, envVars, name, region, repo, runtime, source, subfolder)
        }
    }

    suspend fun describe(name: String): FunctionsDescribeResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Describe")) {
            body = FunctionsDescribeRequest(name)
        }
    }

    suspend fun list(): FunctionsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    suspend fun logs(name: String, logsType: String = "build"): FunctionsLogsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logs")) {
            body = FunctionsLogsRequest(logsType, name)
        }
    }

    suspend fun proxy(id: String): FunctionsProxyResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Proxy")) {
            body = FunctionsProxyRequest(id)
        }
    }

    suspend fun regions(): FunctionsRegionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Regions"))
    }

    suspend fun reserve(name: String): FunctionsReserveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reserve")) {
            body = FunctionsReserveRequest(name)
        }
    }

    suspend fun runtimes(): FunctionsRuntimesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Runtimes"))
    }

    suspend fun update(name: String, source: String = "") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = FunctionsUpdateRequest(name, source)
        }
    }
}

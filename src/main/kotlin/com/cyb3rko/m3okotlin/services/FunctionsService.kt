package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import com.cyb3rko.m3okotlin.data.Function
import com.cyb3rko.m3okotlin.data.FunctionsReserveResponse.FunctionsReservation
import io.ktor.client.request.*
import kotlinx.serialization.json.JsonObject

private const val SERVICE = "function"

/**
 * **Serverless functions**
 *
 * Deploy and run serverless lambda functions with zero infra management
 *
 * @since 0.1.0
 */
object FunctionsService {

    /**
     * Call a function by name
     * @since 0.1.0
     */
    suspend fun call(name: String, request: JsonObject): FunctionsCallResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Call")) {
            body = FunctionsCallRequest(name, request)
        }
    }

    /**
     * Delete a function by name
     * @since 0.1.0
     */
    suspend fun delete(name: String) {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Delete")) {
            body = FunctionsDeleteRequest(name)
        }
    }

    /**
     * Deploy a group of functions
     * @since 0.1.0
     */
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

    /**
     * Get the info for a deployed function
     * @since 0.1.0
     */
    suspend fun describe(name: String): FunctionsDescribeResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Describe")) {
            body = FunctionsDescribeRequest(name)
        }
    }

    /**
     * List all the deployed functions
     * @since 0.1.0
     */
    suspend fun list(): FunctionsListResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "List"))
    }

    /**
     * Get the logs for a function
     * @since 0.1.0
     */
    suspend fun logs(name: String, logsType: String = "build"): FunctionsLogsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Logs")) {
            body = FunctionsLogsRequest(logsType, name)
        }
    }

    /**
     * Return the backend url for proxying
     * @since 0.1.0
     */
    suspend fun proxy(id: String): FunctionsProxyResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Proxy")) {
            body = FunctionsProxyRequest(id)
        }
    }

    /**
     * Return a list of supported regions
     * @since 0.1.0
     */
    suspend fun regions(): FunctionsRegionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Regions"))
    }

    /**
     * Reserve function names and resources beyond free quota
     * @since 0.1.0
     */
    suspend fun reserve(name: String): FunctionsReserveResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Reserve")) {
            body = FunctionsReserveRequest(name)
        }
    }

    /**
     * Return a list of supported runtimes
     * @since 0.1.0
     */
    suspend fun runtimes(): FunctionsRuntimesResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Runtimes"))
    }

    /**
     * Update a function. Downloads the source, builds and redeploys
     * @since 0.1.0
     */
    suspend fun update(name: String, source: String = "") {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Update")) {
            body = FunctionsUpdateRequest(name, source)
        }
    }

    suspend fun Function.call(request: JsonObject) = call(this.name, request)

    suspend fun Function.delete() = delete(this.name)

    suspend fun Function.logs(logsType: String = "build") = logs(this.name, logsType)

    suspend fun Function.proxy() = proxy(this.name)

    suspend fun Function.update(source: String = "") = update(this.name, source)

    suspend fun FunctionsReservation.deploy(
        repo: String,
        runtime: String,
        branch: String = "master",
        entrypoint: String = name,
        envVars: JsonObject = JsonObject(mapOf()),
        region: String = "europe-west1",
        source: String = "",
        subfolder: String = ""
    ) = deploy(this.name, repo, runtime, branch, entrypoint, envVars, region, source, subfolder)
}

package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "nft"

object NFTsService {

    suspend fun asset(contractAddress: String, tokenID: String): NFTsAssetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Asset")) {
            body = NFTsAssetRequest(contractAddress, tokenID)
        }
    }

    suspend fun assets(
        collection: String = "",
        cursor: String = "",
        limit: Int = 0,
        order: String = "",
        orderBy: String = ""
    ): NFTsAssetsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Assets")) {
            body = NFTsAssetsRequest(collection, cursor, limit, order, orderBy)
        }
    }

    suspend fun collection(slug: String): NFTsCollectionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collection")) {
            body = NFTsCollectionRequest(slug)
        }
    }

    suspend fun collections(limit: Int = 0, offset: Int = 0): NFTsCollectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collections")) {
            body = NFTsCollectionsRequest(limit, offset)
        }
    }
}

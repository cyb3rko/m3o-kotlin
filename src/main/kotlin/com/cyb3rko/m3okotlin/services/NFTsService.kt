package com.cyb3rko.m3okotlin.services

import com.cyb3rko.m3okotlin.M3O
import com.cyb3rko.m3okotlin.data.*
import io.ktor.client.request.*

private const val SERVICE = "nft"

/**
 * **Explore NFT Assets**
 *
 * Explore NFT collections and assets with a simple API.
 *
 * @since 0.1.0
 */
object NFTsService {

    /**
     * Get a single asset by the contract
     * @since 0.1.0
     */
    suspend fun asset(contractAddress: String, tokenID: String): NFTsAssetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Asset")) {
            body = NFTsAssetRequest(contractAddress, tokenID)
        }
    }

    /**
     * Return a list of assets
     * @since 0.1.0
     */
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

    /**
     * Get a collection by its slug
     * @since 0.1.0
     */
    suspend fun collection(slug: String): NFTsCollectionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collection")) {
            body = NFTsCollectionRequest(slug)
        }
    }

    /**
     * Get a list of collections
     * @since 0.1.0
     */
    suspend fun collections(limit: Int = 0, offset: Int = 0): NFTsCollectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collections")) {
            body = NFTsCollectionsRequest(limit, offset)
        }
    }

    suspend fun NFTsAsset.collection() = collection(this.collection.slug)

    suspend fun NFTsCollection.assets(
        cursor: String = "",
        limit: Int = 0,
        order: String = "",
        orderBy: String = ""
    ) = assets(this.slug, cursor, limit, order, orderBy)

    suspend fun NFTsContract.asset(tokenID: String) = asset(this.address, tokenID)
}

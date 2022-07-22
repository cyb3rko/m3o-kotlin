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
object NftsService {

    /**
     * Get a single asset by the contract
     * @since 0.1.0
     */
    suspend fun asset(contractAddress: String, tokenID: String): NftsAssetResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Asset")) {
            body = NftsAssetRequest(contractAddress, tokenID)
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
    ): NftsAssetsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Assets")) {
            body = NftsAssetsRequest(collection, cursor, limit, order, orderBy)
        }
    }

    /**
     * Get a collection by its slug
     * @since 0.1.0
     */
    suspend fun collection(slug: String): NftsCollectionResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collection")) {
            body = NftsCollectionRequest(slug)
        }
    }

    /**
     * Get a list of collections
     * @since 0.1.0
     */
    suspend fun collections(limit: Int = 0, offset: Int = 0): NftsCollectionsResponse {
        return M3O.ktorHttpClient.post(M3O.getUrl(SERVICE, "Collections")) {
            body = NftsCollectionsRequest(limit, offset)
        }
    }

    suspend fun NftsAsset.collection() = collection(this.collection.slug)

    suspend fun NftsCollection.assets(
        cursor: String = "",
        limit: Int = 0,
        order: String = "",
        orderBy: String = ""
    ) = assets(this.slug, cursor, limit, order, orderBy)

    suspend fun NftsContract.asset(tokenID: String) = asset(this.address, tokenID)
}

package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.serializer

// Requests & Responses + Data (single use)

@Serializable
internal data class NFTsAssetRequest(
    @SerialName("contract_address")
    val contractAddress: String,
    @SerialName("token_id")
    val tokenID: String
)

@Serializable
data class NFTsAssetResponse(val asset: NFTsAsset)

@Serializable
internal data class NFTsAssetsRequest(
    val collection: String,
    val cursor: String,
    val limit: Int,
    val order: String,
    @SerialName("order_by")
    val orderBy: String
)

@Serializable
data class NFTsAssetsResponse(
    val assets: List<NFTsAsset>,
    val next: String,
    val previous: String
)

@Serializable
internal data class NFTsCollectionRequest(val slug: String)

@Serializable
data class NFTsCollectionResponse(val collection: NFTsCollection)

@Serializable
internal data class NFTsCollectionsRequest(val limit: Int, val offset: Int)

@Serializable
data class NFTsCollectionsResponse(val collections: List<NFTsCollection>)

// Data (multiple use)

@Serializable
data class NFTsAccount(
    val address: String,
    @SerialName("profile_url")
    val profileURL: String,
    val username: String
)

@Serializable
data class NFTsAsset(
    val collection: NFTsCollection,
    val contract: NFTsContract,
    val creator: NFTsAccount,
    val description: String,
    val id: Int,
    @SerialName("image_url")
    val imageURL: String,
    @SerialName("last_sale")
    val lastSale: NFTsSale,
    @SerialName("listing_date")
    val listingDate: String,
    val name: String,
    val owner: NFTsAccount,
    val permalink: String,
    val presale: Boolean,
    val sales: Int,
    @SerialName("token_id")
    val tokenID: String,
    val traits: List<NFTsAssetTrait>
)

@Serializable
data class NFTsAssetTrait(
    @SerialName("display_type")
    val displayType: String? = null,
    @SerialName("max_value")
    val maxValue: String? = null,
    val order: String? = null,
    @SerialName("trait_count")
    val traitCount: Int,
    @SerialName("trait_type")
    val traitType: String,
    @Serializable(with = NFTsAssetTraitValueSerializer::class)
    val value: String
) {

    private object NFTsAssetTraitValueSerializer: JsonTransformingSerializer<String>(serializer<String>()) {
        override fun transformDeserialize(element: JsonElement): JsonElement {
            return JsonPrimitive(element.toString())
        }
    }
}

@Serializable
data class NFTsCollection(
    @SerialName("banner_image_url")
    val bannerImageURL: String,
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val editors: List<String>,
    @SerialName("external_link")
    val externalLink: String,
    @SerialName("image_url")
    val imageURL: String,
    val name: String,
    @SerialName("payment_tokens")
    val paymentTokens: List<NFTsPaymentToken>,
    @SerialName("payout_address")
    val payoutAddress: String,
    @SerialName("primary_asset_contracts")
    val primaryAssetContracts: List<NFTsContract>,
    @SerialName("safelist_request_status")
    val safelistRequestStatus: String,
    @SerialName("seller_fees")
    val sellerFees: String,
    val slug: String,
    val stats: NFTsCollectionStats,
    val traits: Map<String, Map<String, Float>>
)

@Serializable
data class NFTsContract(
    val address: String,
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val name: String,
    val owner: Int,
    @SerialName("payout_address")
    val payoutAddress: String,
    val schema: String,
    @SerialName("seller_fees")
    val sellerFees: String,
    val symbol: String,
    val type: String
)

@Serializable
data class NFTsPaymentToken(
    val address: String,
    val decimals: Int,
    @SerialName("eth_price")
    val ethPrice: String,
    val id: Int,
    @SerialName("image_url")
    val imageURL: String,
    val name: String,
    val symbol: String,
    @SerialName("usd_price")
    val usdPrice: String
)

@Serializable
data class NFTsSale(
    @SerialName("asset_decimals")
    val assetDecimals: Int,
    @SerialName("asset_token_id")
    val assetTokenID: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("event_timestamp")
    val eventTimestamp: String,
    @SerialName("event_type")
    val eventType: String,
    @SerialName("payment_token")
    val paymentToken: NFTsPaymentToken? = null,
    val quantity: String,
    @SerialName("total_price")
    val totalPrice: String,
    val transaction: NFTsTransaction? = null
)

@Serializable
data class NFTsCollectionStats(
    @SerialName("average_price")
    val averagePrice: Double? = null,
    val count: Int? = null,
    @SerialName("floor_price")
    val floorPrice: Double? = null,
    @SerialName("market_cap")
    val marketCap: Double? = null,
    @SerialName("num_owners")
    val numOwners: Int? = null,
    @SerialName("num_reports")
    val numReports: Int? = null,
    @SerialName("one_day_average_price")
    val oneDayAveragePrice: Double? = null,
    @SerialName("one_day_change")
    val oneDayChange: Double? = null,
    @SerialName("one_day_sales")
    val oneDaySales: Int? = null,
    @SerialName("one_day_volume")
    val oneDayVolume: Double? = null,
    @SerialName("seven_day_average_price")
    val sevenDayAveragePrice: Double? = null,
    @SerialName("seven_day_change")
    val sevenDayChange: Double? = null,
    @SerialName("seven_day_sales")
    val sevenDaySales: Int? = null,
    @SerialName("seven_day_volume")
    val sevenDayVolume: Double? = null,
    @SerialName("thirty_day_average_price")
    val thirtyDayAveragePrice: Double? = null,
    @SerialName("thirty_day_change")
    val thirtyDayChange: Double? = null,
    @SerialName("thirty_day_sales")
    val thirtyDaySales: Int? = null,
    @SerialName("thirty_day_volume")
    val thirtyDayVolume: Double? = null,
    @SerialName("total_sales")
    val totalSales: Int? = null,
    @SerialName("total_supply")
    val totalSupply: Int? = null,
    @SerialName("total_volume")
    val totalVolume: Double? = null,
)

@Serializable
data class NFTsTransaction(
    @SerialName("block_hash")
    val blockHash: String,
    @SerialName("block_number")
    val blockNumber: String,
    @SerialName("from_account")
    val fromAccount: NFTsAccount,
    val id: Int,
    val timestamp: String,
    @SerialName("to_account")
    val toAccount: NFTsAccount,
    @SerialName("transaction_hash")
    val transactionHash: String,
    @SerialName("transaction_index")
    val transactionIndex: String
)

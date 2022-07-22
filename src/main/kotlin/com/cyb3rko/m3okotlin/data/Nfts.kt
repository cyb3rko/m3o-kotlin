package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.JsonTransformingSerializer
import kotlinx.serialization.serializer

// Requests & Responses + Data (single use)

@Serializable
internal data class NftsAssetRequest(
    @SerialName("contract_address")
    val contractAddress: String,
    @SerialName("token_id")
    val tokenId: String
)

@Serializable
data class NftsAssetResponse(val asset: NftsAsset)

@Serializable
internal data class NftsAssetsRequest(
    val collection: String,
    val cursor: String,
    val limit: Int,
    val order: String,
    @SerialName("order_by")
    val orderBy: String
)

@Serializable
data class NftsAssetsResponse(
    val assets: List<NftsAsset>,
    val next: String,
    val previous: String
)

@Serializable
internal data class NftsCollectionRequest(val slug: String)

@Serializable
data class NftsCollectionResponse(val collection: NftsCollection)

@Serializable
internal data class NftsCollectionsRequest(val limit: Int, val offset: Int)

@Serializable
data class NftsCollectionsResponse(val collections: List<NftsCollection>)

// Data (multiple use)

@Serializable
data class NftsAccount(
    val address: String,
    @SerialName("profile_url")
    val profileUrl: String,
    val username: String
)

@Serializable
data class NftsAsset(
    val collection: NftsCollection,
    val contract: NftsContract,
    val creator: NftsAccount,
    val description: String,
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    @SerialName("last_sale")
    val lastSale: NftsSale,
    @SerialName("listing_date")
    val listingDate: String,
    val name: String,
    val owner: NftsAccount,
    val permalink: String,
    val presale: Boolean,
    val sales: Int,
    @SerialName("token_id")
    val tokenId: String,
    val traits: List<NftsAssetTrait>
)

@Serializable
data class NftsAssetTrait(
    @SerialName("display_type")
    val displayType: String? = null,
    @SerialName("max_value")
    val maxValue: String? = null,
    val order: String? = null,
    @SerialName("trait_count")
    val traitCount: Int,
    @SerialName("trait_type")
    val traitType: String,
    @Serializable(with = NftsAssetTraitValueSerializer::class)
    val value: String
) {

    private object NftsAssetTraitValueSerializer: JsonTransformingSerializer<String>(serializer<String>()) {
        override fun transformDeserialize(element: JsonElement): JsonElement {
            return JsonPrimitive(element.toString())
        }
    }
}

@Serializable
data class NftsCollection(
    @SerialName("banner_image_url")
    val bannerImageUrl: String,
    @SerialName("created_at")
    val createdAt: String,
    val description: String,
    val editors: List<String>,
    @SerialName("external_link")
    val externalLink: String,
    @SerialName("image_url")
    val imageUrl: String,
    val name: String,
    @SerialName("payment_tokens")
    val paymentTokens: List<NftsPaymentToken>,
    @SerialName("payout_address")
    val payoutAddress: String,
    @SerialName("primary_asset_contracts")
    val primaryAssetContracts: List<NftsContract>,
    @SerialName("safelist_request_status")
    val safelistRequestStatus: String,
    @SerialName("seller_fees")
    val sellerFees: String,
    val slug: String,
    val stats: NftsCollectionStats,
    val traits: Map<String, Map<String, Float>>
)

@Serializable
data class NftsContract(
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
data class NftsPaymentToken(
    val address: String,
    val decimals: Int,
    @SerialName("eth_price")
    val ethPrice: String,
    val id: Int,
    @SerialName("image_url")
    val imageUrl: String,
    val name: String,
    val symbol: String,
    @SerialName("usd_price")
    val usdPrice: String
)

@Serializable
data class NftsSale(
    @SerialName("asset_decimals")
    val assetDecimals: Int,
    @SerialName("asset_token_id")
    val assetTokenId: String,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("event_timestamp")
    val eventTimestamp: String,
    @SerialName("event_type")
    val eventType: String,
    @SerialName("payment_token")
    val paymentToken: NftsPaymentToken? = null,
    val quantity: String,
    @SerialName("total_price")
    val totalPrice: String,
    val transaction: NftsTransaction? = null
)

@Serializable
data class NftsCollectionStats(
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
data class NftsTransaction(
    @SerialName("block_hash")
    val blockHash: String,
    @SerialName("block_number")
    val blockNumber: String,
    @SerialName("from_account")
    val fromAccount: NftsAccount,
    val id: Int,
    val timestamp: String,
    @SerialName("to_account")
    val toAccount: NftsAccount,
    @SerialName("transaction_hash")
    val transactionHash: String,
    @SerialName("transaction_index")
    val transactionIndex: String
)

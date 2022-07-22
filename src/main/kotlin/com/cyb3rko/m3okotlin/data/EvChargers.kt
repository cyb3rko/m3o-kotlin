package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EvChargersReferenceDataResponse(
    @SerialName("charger_types")
    val chargerTypes: List<EvChargerType>,
    @SerialName("checkin_status_types")
    val checkinStatusTypes: List<EvChargerCheckinStatusType>,
    @SerialName("connection_types")
    val connectionTypes: List<EvChargerConnectionType>,
    val countries: List<EvChargerCountry>,
    @SerialName("current_types")
    val currentTypes: List<EvChargerCurrentType>,
    @SerialName("data_providers")
    val dataProviders: List<EvChargerDataProvider>,
    val operators: List<EvChargerOperator>,
    @SerialName("status_types")
    val statusTypes: List<EvChargerStatusType>,
    @SerialName("submission_status_types")
    val submissionStatusTypes: List<EvChargerSubmissionStatusType>,
    @SerialName("usage_types")
    val usageTypes: List<EvChargerUsageType>,
    @SerialName("user_comment_types")
    val userCommentTypes: List<EvChargerUserCommentType>
)

@Serializable
data class EvChargerType(
    val comments: String,
    val id: String,
    @SerialName("is_fast_charge_capable")
    val isFastChargeCapable: Boolean,
    val title: String
)

@Serializable
data class EvChargerCheckinStatusType(
    val id: String,
    @SerialName("is_automated")
    val isAutomated: Boolean,
    @SerialName("is_positive")
    val isPositive: Boolean,
    val title: String
)

@Serializable
data class EvChargerConnectionType(
    @SerialName("formal_name")
    val formalName: String,
    val id: String,
    @SerialName("is_discontinued")
    val isDiscontinued: Boolean,
    @SerialName("is_obsolete")
    val isObsolete: Boolean,
    val title: String,
)

@Serializable
data class EvChargerCountry(
    @SerialName("continent_code")
    val continentCode: String,
    val id: String,
    @SerialName("iso_code")
    val isoCode: String,
    val title: String,
)

@Serializable
data class EvChargerCurrentType(
    val description: String,
    val id: String,
    val title: String
)

@Serializable
data class EvChargerDataProvider(
    val comments: String,
    @SerialName("data_provider_status_type")
    val dataProviderStatusType: EvChargerDataProviderStatusType,
    val id: String,
    val license: String,
    val title: String,
    val website: String
)

@Serializable
data class EvChargerDataProviderStatusType(
    val id: String,
    @SerialName("is_provider_enabled")
    val isProviderEnabled: Boolean,
    val title: String
)

@Serializable
data class EvChargerOperator(
    val comments: String,
    @SerialName("contact_email")
    val contactEmail: String,
    @SerialName("fault_report_email")
    val faultReportEmail: String,
    val id: String,
    @SerialName("is_private_individual")
    val isPrivateIndividual: Boolean,
    @SerialName("phone_primary")
    val phonePrimary: String,
    @SerialName("phone_secondary")
    val phoneSecondary: String,
    val title: String,
    val website: String
)

@Serializable
data class EvChargerStatusType(
    val id: String,
    @SerialName("is_operational")
    val isOperational: Boolean,
    val title: String,
)

@Serializable
data class EvChargerSubmissionStatusType(
    val id: String,
    @SerialName("is_live")
    val isLive: Boolean,
    val title: String
)

@Serializable
data class EvChargerUsageType(
    val id: String,
    @SerialName("is_access_key_required")
    val isAccessKeyRequired: Boolean,
    @SerialName("is_membership_required")
    val isMembershipRequired: Boolean,
    @SerialName("is_pay_at_location")
    val isPayAtLocation: Boolean,
    val title: String
)

@Serializable
data class EvChargerUserCommentType(val id: String, val title: String)

@Serializable
internal data class EvChargersSearchBoxRequest(
    val box: EvChargerLocationBox,
    @SerialName("connection_types")
    val connectionTypes: List<String>,
    @SerialName("country_id")
    val countryId: String,
    val distance: Int,
    val levels: List<String>,
    @SerialName("max_results")
    val maxResults: Int,
    @SerialName("min_power")
    val minPower: Int,
    val operators: List<String>,
    @SerialName("usage_types")
    val usageTypes: List<String>
)

@Serializable
internal data class EvChargersSearchLocationRequest(
    @SerialName("connection_types")
    val connectionTypes: List<String>,
    @SerialName("country_id")
    val countryId: String,
    val distance: Int,
    val levels: List<String>,
    val location: EvChargerCoordinates,
    @SerialName("max_results")
    val maxResults: Int,
    @SerialName("min_power")
    val minPower: Int,
    val operators: List<String>,
    @SerialName("usage_types")
    val usageTypes: List<String>
)

@Serializable
data class EvChargerLocationBox(
    @SerialName("bottom_left")
    val bottomLeft: EvChargerCoordinates,
    @SerialName("top_right")
    val topRight: EvChargerCoordinates
)

@Serializable
data class EvChargerCoordinates(val latitude: Double, val longitude: Double)

@Serializable
data class EvChargersSearchResponse(
    val pois: List<EvCharger>
)

@Serializable
data class EvCharger(
    val address: EvChargerAddress,
    val connections: List<EvChargerConnection>,
    @SerialName("data_provider_id")
    val dataProviderId: String,
    val id: String,
    @SerialName("operator_id")
    val operatorId: String,
    @SerialName("usage_type_id")
    val usageTypeId: String
)

@Serializable
data class EvChargerAddress(
    @SerialName("access_comments")
    val accessComments: String,
    @SerialName("address_line_1")
    val addressLine1: String,
    @SerialName("address_line_2")
    val addressLine2: String,
    val country: EvChargerCountry,
    @SerialName("country_id")
    val countryId: String,
    val location: EvChargerCoordinates,
    val postcode: String,
    @SerialName("state_or_province")
    val stateOrProvince: String,
    val title: String,
    val town: String
)

@Serializable
data class EvChargerConnection(
    val amps: Int,
    @SerialName("connection_type")
    val connectionType: EvChargerConnectionType,
    @SerialName("connection_type_id")
    val connectionTypeId: String,
    val current: String,
    val level: EvChargerType,
    val level_id: String,
    val power: Float,
    val reference: String,
    val voltage: Int
)

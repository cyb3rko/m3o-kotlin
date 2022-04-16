package com.cyb3rko.m3okotlin.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class EVChargersReferenceDataResponse(
    @SerialName("charger_types")
    val chargerTypes: List<EVChargerType>,
    @SerialName("checkin_status_types")
    val checkinStatusTypes: List<EVChargerCheckinStatusType>,
    @SerialName("connection_types")
    val connectionTypes: List<EVChargerConnectionType>,
    val countries: List<EVChargerCountry>,
    @SerialName("current_types")
    val currentTypes: List<EVChargerCurrentType>,
    @SerialName("data_providers")
    val dataProviders: List<EVChargerDataProvider>,
    val operators: List<EVChargerOperator>,
    @SerialName("status_types")
    val statusTypes: List<EVChargerStatusType>,
    @SerialName("submission_status_types")
    val submissionStatusTypes: List<EVChargerSubmissionStatusType>,
    @SerialName("usage_types")
    val usageTypes: List<EVChargerUsageType>,
    @SerialName("user_comment_types")
    val userCommentTypes: List<EVChargerUserCommentType>
)

@Serializable
data class EVChargerType(
    val id: String,
    val title: String,
    val comments: String,
    @SerialName("is_fast_charge_capable")
    val isFastChargeCapable: Boolean
)

@Serializable
data class EVChargerCheckinStatusType(
    val id: String,
    val title: String,
    @SerialName("is_positive")
    val isPositive: Boolean,
    @SerialName("is_automated")
    val isAutomated: Boolean
)

@Serializable
data class EVChargerConnectionType(
    val id: String,
    val title: String,
    @SerialName("formal_name")
    val formalName: String,
    @SerialName("is_discontinued")
    val isDiscontinued: Boolean,
    @SerialName("is_obsolete")
    val isObsolete: Boolean
)

@Serializable
data class EVChargerCountry(
    val id: String,
    val title: String,
    @SerialName("iso_code")
    val isoCode: String,
    @SerialName("continent_code")
    val continentCode: String
)

@Serializable
data class EVChargerCurrentType(
    val id: String,
    val title: String,
    val description: String
)

@Serializable
data class EVChargerDataProvider(
    val id: String,
    val title: String,
    val website: String,
    val comments: String,
    @SerialName("data_provider_status_type")
    val dataProviderStatusType: EVChargerDataProviderStatusType,
    val license: String
)

@Serializable
data class EVChargerDataProviderStatusType(
    val id: String,
    val title: String,
    @SerialName("is_provider_enabled")
    val isProviderEnabled: Boolean
)

@Serializable
data class EVChargerOperator(
    val id: String,
    val title: String,
    val website: String,
    val comments: String,
    @SerialName("is_private_individual")
    val isPrivateIndividual: Boolean,
    @SerialName("contact_email")
    val contactEmail: String,
    @SerialName("phone_primary")
    val phonePrimary: String,
    @SerialName("phone_secondary")
    val phoneSecondary: String,
    @SerialName("fault_report_email")
    val faultReportEmail: String
)

@Serializable
data class EVChargerStatusType(
    val id: String,
    val title: String,
    @SerialName("is_operational")
    val isOperational: Boolean
)

@Serializable
data class EVChargerSubmissionStatusType(
    val id: String,
    val title: String,
    @SerialName("is_live")
    val isLive: Boolean
)

@Serializable
data class EVChargerUsageType(
    val id: String,
    val title: String,
    @SerialName("is_pay_at_location")
    val isPayAtLocation: Boolean,
    @SerialName("is_membership_required")
    val isMembershipRequired: Boolean,
    @SerialName("is_access_key_required")
    val isAccessKeyRequired: Boolean
)

@Serializable
data class EVChargerUserCommentType(val id: String, val title: String)

@Serializable
internal data class EVChargersSearchBoxRequest(
    val box: EVChargerLocationBox,
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
internal data class EVChargersSearchLocationRequest(
    @SerialName("connection_types")
    val connectionTypes: List<String>,
    @SerialName("country_id")
    val countryId: String,
    val distance: Int,
    val levels: List<String>,
    val location: EVChargerCoordinates,
    @SerialName("max_results")
    val maxResults: Int,
    @SerialName("min_power")
    val minPower: Int,
    val operators: List<String>,
    @SerialName("usage_types")
    val usageTypes: List<String>
)

@Serializable
data class EVChargerLocationBox(
    @SerialName("bottom_left")
    val bottomLeft: EVChargerCoordinates,
    @SerialName("top_right")
    val topRight: EVChargerCoordinates
)

@Serializable
data class EVChargerCoordinates(val latitude: Double, val longitude: Double)

@Serializable
data class EVChargersSearchResponse(
    val pois: List<EVCharger>
)

@Serializable
data class EVCharger(
    val id: String,
    @SerialName("data_provider_id")
    val dataProviderId: String,
    @SerialName("operator_id")
    val operatorId: String,
    @SerialName("usage_type_id")
    val usageTypeId: String,
    val address: EVChargerAddress,
    val connections: List<EVChargerConnection>
)

@Serializable
data class EVChargerAddress(
    val location: EVChargerCoordinates,
    val title: String,
    @SerialName("address_line_1")
    val addressLine1: String,
    @SerialName("address_line_2")
    val addressLine2: String,
    val town: String,
    @SerialName("state_or_province")
    val stateOrProvince: String,
    @SerialName("access_comments")
    val accessComments: String,
    val postcode: String,
    @SerialName("country_id")
    val countryId: String,
    val country: EVChargerCountry
)

@Serializable
data class EVChargerConnection(
    @SerialName("connection_type_id")
    val connectionTypeId: String,
    val reference: String,
    val level_id: String,
    val amps: Int,
    val voltage: Int,
    val power: Float,
    val current: String,
    @SerialName("connection_type")
    val connectionType: EVChargerConnectionType,
    val level: EVChargerType
)
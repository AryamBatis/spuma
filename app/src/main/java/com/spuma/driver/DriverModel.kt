package com.spuma.driver

import java.sql.Date
import java.time.LocalDateTime
import kotlinx.serialization.*

@Serializable
data class DriverModel(
    @SerialName("email") val email: String? = null,
    @SerialName("id") val id: Int? = null,
    @SerialName("lang") val lang: String? = null,
    @SerialName("mobile") val mobile: String? = null,
    @SerialName("token") val token: Any? = null,
    @SerialName("token_expired_at") val token_expired_at: LocalDateTime? = null,
    @SerialName("country_code") val username: String? = null,
    @SerialName("email") val country_code: String? = null,
    @SerialName("device") val device: DeviceModel? = null,
    @SerialName("type") val type: String? = null,
)

@Serializable
data class DeviceModel(
    @SerialName("uid") val uid: String? = null,
    @SerialName("type") val type: String? = null
)
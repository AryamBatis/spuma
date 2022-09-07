package com.spuma.driver

import java.sql.Date
import java.time.LocalDateTime

data class DriverModel(
    val email: String = "",
    val id: Int = 0,
    val lang: String = "",
    val mobile: String = "",
    val token: Any = "",
    val token_expired_at: LocalDateTime = LocalDateTime.now(),
    val username: String = "",
    val country_code: String = "",
    val devices: DeviceModel = DeviceModel(),
    val type: String = ""
)

data class DeviceModel(
        val uid: String = "",
        val type: String = ""
)
package com.spuma.driver

data class ResponseModel(
    val email: String,
    val id: Int,
    val lang: String,
    val mobile: String,
    val token: Any,
    val token_expired_at: Any,
    val username: Any
)
package com.spuma.driver.services

import com.spuma.driver.RequestModel
import com.spuma.driver.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("api/v1/drivers/login")
    fun sendReq(): Call<ResponseModel>
}

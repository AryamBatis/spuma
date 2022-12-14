package com.spuma.driver

import com.spuma.driver.DriverModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiInterface {

        @Headers("Content-type: application/json")
        @POST("api/v1/drivers/login")
        fun driverLogin(@Body body: DriverModel): Call<DriverModel>
}

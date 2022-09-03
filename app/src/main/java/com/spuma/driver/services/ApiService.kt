package com.spuma.driver.services

import com.spuma.driver.ResponseModel
import mu.KotlinLogging
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiService {
    private val logger = KotlinLogging.logger {}
    fun request (body: String) {
        val retrofit = ServiceBuilder.buildService(ApiInterface::class.java)
        //val obj = RequestModel(number.toString(),lang,"SA",uid,"android")

        retrofit.sendReq().enqueue(
            object: Callback<ResponseModel> {
                override fun onResponse(
                    call: Call<ResponseModel>,
                    response: Response<ResponseModel>
                ) {
                   // Toast.makeText(this,response.message().toString(), Toast.LENGTH_LONG).show()
                }

                override fun onFailure(call: Call<ResponseModel>, t: Throwable) {
                    logger.error{}
                   // Toast.makeText(this,t.toString(), Toast.LENGTH_LONG).show()
                }

            }
        )
    }

}
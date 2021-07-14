package com.example.paypaycodechallenge.data.source.network

import com.example.paypaycodechallenge.data.model.BaseResponseModel
import com.example.paypaycodechallenge.data.model.RatesLiveResponseModel
import retrofit2.Call
import retrofit2.http.*

interface API {
    @Headers("Content-Type: application/json")
    @GET("live")
    fun getRates(@Query(value = "access_key") key: String?): Call<RatesLiveResponseModel?>?
}
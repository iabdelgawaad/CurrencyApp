package com.example.codechallenge.data.source.network

import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface API {
    @Headers("Content-Type: application/json")
    @GET("latest/")
    fun getRates(@Query(value = "access_key") key: String?,
                 @Query(value = "base") base: String?): Call<LatestExchangeRatesResponseModel?>?
}
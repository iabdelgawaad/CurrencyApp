package com.example.codechallenge.data

import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
import com.example.codechallenge.data.source.network.API
import com.example.codechallenge.data.source.network.RequestManager
import com.example.codechallenge.utils.Constants
import retrofit2.Call

class Repository {
    private var requestManager: RequestManager? = null

    constructor(requestManager: RequestManager) {
        this.requestManager = requestManager
    }

    fun getRates(): Call<LatestExchangeRatesResponseModel?>? {
        return requestManager?.startRequest(API::class.java)?.getRates(Constants.ACCESS_KEY)
    }
}
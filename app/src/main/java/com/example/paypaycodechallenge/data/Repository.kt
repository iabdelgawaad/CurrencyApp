package com.example.paypaycodechallenge.data

import com.example.paypaycodechallenge.data.model.LatestExchangeRatesResponseModel
import com.example.paypaycodechallenge.data.source.network.API
import com.example.paypaycodechallenge.data.source.network.RequestManager
import com.example.paypaycodechallenge.utils.Constants
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
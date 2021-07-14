package com.example.paypaycodechallenge.data

import com.example.paypaycodechallenge.data.model.BaseResponseModel
import com.example.paypaycodechallenge.data.model.RatesLiveResponseModel
import com.example.paypaycodechallenge.data.source.network.API
import com.example.paypaycodechallenge.data.source.network.RequestManager
import com.example.paypaycodechallenge.utils.Constants
import retrofit2.Call

class Repository {
    private var requestManager: RequestManager? = null

    constructor(requestManager: RequestManager) {
        this.requestManager = requestManager
    }

    fun getRates(): Call<RatesLiveResponseModel?>? {
        return requestManager?.startRequest(API::class.java)?.getRates(Constants.ACCESS_KEY)
    }
}
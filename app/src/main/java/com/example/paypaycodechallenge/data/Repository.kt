package com.example.paypaycodechallenge.data

import com.example.paypaycodechallenge.data.source.network.RequestManager

class Repository {
    private var requestManager: RequestManager? = null

    constructor(requestManager: RequestManager) {
        this.requestManager = requestManager
    }

    fun getRates()
    {

    }
}
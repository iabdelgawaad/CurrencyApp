package com.example.paypaycodechallenge.view

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.paypaycodechallenge.data.Repository
import com.example.paypaycodechallenge.data.model.LatestExchangeRatesResponseModel
import com.example.paypaycodechallenge.data.source.network.RequestManager
import retrofit2.Call

class ViewModel(application: Application) : AndroidViewModel(application) {
    var repository: Repository? = null

    init {
        repository = RequestManager.instance?.let { Repository(it) }
    }

    fun getRates(): Call<LatestExchangeRatesResponseModel?>? {
      return  repository?.getRates()
    }
}
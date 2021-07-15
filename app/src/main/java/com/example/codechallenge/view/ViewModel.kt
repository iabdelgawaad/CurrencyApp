package com.example.codechallenge.view

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.example.codechallenge.MyBaseApplication
import com.example.codechallenge.data.Repository
import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
import com.example.codechallenge.data.source.network.RequestManager
import retrofit2.Call

class ViewModel(application: Application) : AndroidViewModel(application) {
    var repository: Repository? = null

    init {
        repository = RequestManager.instance?.let { Repository(it) }
    }

    companion object{
        private val viewModel = MyBaseApplication.getInstance()?.let { ViewModel(it) }
        @Synchronized fun getInstance(): ViewModel?
        {
            if (viewModel == null)
            {
                return MyBaseApplication.getInstance()?.let { ViewModel(it) }
            }
            return viewModel
        }
    }

    fun getRates(): Call<LatestExchangeRatesResponseModel?>? {
      return  repository?.getRates()
    }
}
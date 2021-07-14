package com.example.paypaycodechallenge.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.paypaycodechallenge.R
import com.example.paypaycodechallenge.data.model.BaseResponseModel
import com.example.paypaycodechallenge.data.model.RatesLiveResponseModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(ViewModel::class.java)

        viewModel?.getRates()?.enqueue(object : Callback,
            retrofit2.Callback<RatesLiveResponseModel?> {
            override fun onResponse(
                call: Call<RatesLiveResponseModel?>,
                baseResponse: Response<RatesLiveResponseModel?>
            ) {
                Log.d("result", baseResponse?.message())
            }

            override fun onFailure(baseResponse: Call<RatesLiveResponseModel?>, t: Throwable) {
                t?.message?.let { Log.d("result", it) }
            }
        })
    }
}
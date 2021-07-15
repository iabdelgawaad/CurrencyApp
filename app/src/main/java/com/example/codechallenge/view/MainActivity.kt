package com.example.codechallenge.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.example.codechallenge.R
import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
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
            retrofit2.Callback<LatestExchangeRatesResponseModel?> {
            override fun onResponse(
                call: Call<LatestExchangeRatesResponseModel?>,
                baseResponse: Response<LatestExchangeRatesResponseModel?>) {
                Log.d("result", baseResponse?.message())
                baseResponse?.isSuccessful?.let {
                    baseResponse?.body()?.success?.let { isSuccess ->
                        if (isSuccess) {

                        } else {
                            AlertDialog.Builder(this@MainActivity)
                                .setTitle(getString(R.string.error_alert_dialog_title))
                                .setMessage(baseResponse?.body()?.error?.info)
                                .setPositiveButton(getString(R.string.ok_text), null)
                                .show()
                        }
                    }
                }
            }

            override fun onFailure(
                baseResponse: Call<LatestExchangeRatesResponseModel?>, t: Throwable) {
                t?.message?.let { Log.d("result", it) }
            }
        })
    }
}
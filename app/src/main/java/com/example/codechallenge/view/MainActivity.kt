package com.example.codechallenge.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.codechallenge.R
import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback


class MainActivity : AppCompatActivity() {
    lateinit var viewModel: ViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        showLoading()
        viewModel?.getRates()?.enqueue(object : Callback,
            retrofit2.Callback<LatestExchangeRatesResponseModel?> {
            override fun onResponse(
                call: Call<LatestExchangeRatesResponseModel?>,
                baseResponse: Response<LatestExchangeRatesResponseModel?>
            ) {
                hideLoading()
                Log.d("result", baseResponse?.message())
                baseResponse?.isSuccessful?.let {
                    baseResponse?.body()?.success?.let { isSuccess ->
                        if (isSuccess) {

                        } else {
                            this@MainActivity?.let {
                                val dialog = AlertDialog.Builder(it)
                                    .setTitle(getString(R.string.error_alert_dialog_title))
                                    .setMessage(baseResponse?.body()?.error?.info)
                                    .setPositiveButton(getString(R.string.ok_text), null)
                                if (!(this@MainActivity).isFinishing) {
                                    dialog?.show()
                                }
                            }
                        }
                    }
                }
            }

            override fun onFailure(
                baseResponse: Call<LatestExchangeRatesResponseModel?>, t: Throwable
            ) {
                hideLoading()
                t?.message?.let { Log.d("result", it) }
            }
        })
    }

    fun showLoading() {
        progress_bar?.visibility = View.VISIBLE
    }

    fun hideLoading() {
        progress_bar?.visibility = View.GONE
    }
}
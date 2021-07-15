package com.example.codechallenge.view

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.codechallenge.R
import com.example.codechallenge.data.model.LatestExchangeRatesResponseModel
import com.example.codechallenge.data.model.Rates
import kotlinx.android.synthetic.main.fragment_exchange_rates.*
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class ExchangeRatesFragment : Fragment(), ExchangeRatesAdapter.OnCurrencyClickListener {
    var adapter: ExchangeRatesAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_exchange_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        ViewModel?.getInstance()?.getRates()?.enqueue(object : Callback,
            retrofit2.Callback<LatestExchangeRatesResponseModel?> {
            override fun onResponse(
                call: Call<LatestExchangeRatesResponseModel?>,
                baseResponse: Response<LatestExchangeRatesResponseModel?>
            ) {
                (activity as MainActivity?)?.hideLoading()
                Log.d("result", baseResponse?.message())
                baseResponse?.isSuccessful?.let {
                    baseResponse?.body()?.success?.let { isSuccess ->
                        drawCurrencyList(null)
                        if (isSuccess) {
                        } else {
                            activity?.let {
                                val dialog = AlertDialog.Builder(it)
                                    .setTitle(getString(R.string.error_alert_dialog_title))
                                    .setMessage(baseResponse?.body()?.error?.info)
                                    .setPositiveButton(getString(R.string.ok_text), null)
                                if (!(it)?.isFinishing) {
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
                (activity as MainActivity?)?.hideLoading()
                t?.message?.let { Log.d("result", it) }
            }
        })
    }

    fun drawCurrencyList(data: List<Rates>?) {
        val currencyNamesList: List<String> = listOf("SAR", "EGP", "USD")
        val currencyValuesList: List<String> = listOf("4.43", "18.55", "1.18")
        adapter = ExchangeRatesAdapter(activity, currencyNamesList, currencyValuesList, this)
        rates_recycler_view?.adapter = adapter
        rates_recycler_view?.layoutManager = LinearLayoutManager(activity)
        rates_recycler_view.addItemDecoration(
            DividerItemDecoration(
                rates_recycler_view.context,
                DividerItemDecoration.VERTICAL
            )
        )
        adapter?.notifyDataSetChanged()
    }

    override fun onCurrencyClick(currencyName: String, value: String?) {
        val bundle = Bundle().apply {
            putString("SELECTED_CURRENCY_NAME", currencyName)
            putString("SELECTED_CURRENCY_VALUE", value)

        }
        view?.let {
            Navigation.findNavController(it)
                .navigate(R.id.action_exchangeRatesFragment_to_currencyConverterFragment2, bundle)
        };
    }
}
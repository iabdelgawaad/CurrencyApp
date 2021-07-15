package com.example.codechallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.codechallenge.R
import kotlinx.android.synthetic.main.fragment_exchange_rates.*

class ExchangeRatesFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_exchange_rates, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button?.setOnClickListener {
            Navigation.findNavController(view)
                .navigate(R.id.action_exchangeRatesFragment_to_currencyConverterFragment2);
        }
    }
}
package com.example.codechallenge.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import com.example.codechallenge.R
import kotlinx.android.synthetic.main.fragment_currency_converter.*

class CurrencyConverterFragment : Fragment() {
    private var currencyName: String? = null
    private var currencyValue: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            currencyName = it.getString("SELECTED_CURRENCY_NAME")
            currencyValue = it.getString("SELECTED_CURRENCY_VALUE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_currency_converter, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        target_currency_name?.text = currencyName
        target_currency_edit?.setText(currencyValue)

        base_currency_edit?.doOnTextChanged { inputText, _, _, _ ->
            inputText?.let {
                it?.isNotEmpty()?.let { notEmpty ->
                    if (notEmpty) {
                        val input = inputText?.toString()?.toDouble()
                        currencyValue?.toDouble()?.let {
                            target_currency_edit?.setText(input?.times(it)?.toString())
                        }
                    }
                }
            }
        }
    }
}
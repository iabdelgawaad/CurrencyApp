package com.example.codechallenge.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.R
import kotlinx.android.synthetic.main.item_currency_list.view.*

class ExchangeRatesAdapter(
    var context: Context?,
    var data: List<String>?,
    var values: List<String>?,
    var listener: OnCurrencyClickListener?
) : RecyclerView.Adapter<ExchangeRatesAdapter.MyViewHolder>() {

    interface OnCurrencyClickListener {
        fun onCurrencyClick(currencyName: String, get: String?);
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_currency_list, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.itemView?.currency_name?.text = data?.get(position)
        holder?.itemView?.currency_value?.text = values?.get(position)
        holder?.itemView?.currency_name?.setOnClickListener {
            data?.get(position)?.let { it1 -> listener?.onCurrencyClick(it1, values?.get(position)) }
        }
    }

    override fun getItemCount(): Int {
        data?.let {
            return it.size
        }
        return 0
    }
}
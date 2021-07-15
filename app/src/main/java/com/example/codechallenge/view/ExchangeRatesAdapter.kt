package com.example.codechallenge.view

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.codechallenge.data.model.Rates

class ExchangeRatesAdapter(
    var context: Context?,
    var data: List<Rates>?,
    var listener: OnCurrencyClickListener?
) :
    RecyclerView.Adapter<ExchangeRatesAdapter.MyViewHolder>() {

    interface OnCurrencyClickListener {
        fun onCurrencyClick();
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        data?.let {
            return it.size
        }
        return 0
    }
}
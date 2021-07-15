package com.example.codechallenge.data.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class LatestExchangeRatesResponseModel(
    @SerializedName("base")
    val base: String,
    @SerializedName("date")
    val date: String,
    @SerializedName("rates")
    val rates: Rates,
    @SerializedName("timestamp")
    val timestamp: Int,
    @SerializedName("error")
    val error: Error,
    @SerializedName("success")
    val success: Boolean
): Serializable
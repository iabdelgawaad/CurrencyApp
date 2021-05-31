package com.example.paypaycodechallenge.data.model

import com.google.gson.annotations.SerializedName

data class Error(
    @SerializedName("code")
    val code: Int,
    @SerializedName("info")
    val info: String
)
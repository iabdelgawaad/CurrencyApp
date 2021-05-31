package com.example.paypaycodechallenge.data.model

import com.google.gson.annotations.SerializedName


data class ResponseModel(
    @SerializedName("error")
    val error: Error,
    @SerializedName("success")
    val success: Boolean
)
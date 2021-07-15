package com.example.paypaycodechallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Error(
    @SerializedName("code")
    val code: Int,
    @SerializedName("info")
    val info: String
):Serializable
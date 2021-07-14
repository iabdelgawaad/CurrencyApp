package com.example.paypaycodechallenge.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BaseResponseModel(
    @SerializedName("error")
    val error: Error,
    @SerializedName("success")
    open val success: Boolean
) : Serializable
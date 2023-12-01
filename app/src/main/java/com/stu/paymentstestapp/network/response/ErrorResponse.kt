package com.stu.paymentstestapp.network.response

import com.google.gson.annotations.SerializedName

data class ErrorResponse(
    @SerializedName("error_code") val errorCode: Int,
    @SerializedName("error_msg") val errorMsg: String
)
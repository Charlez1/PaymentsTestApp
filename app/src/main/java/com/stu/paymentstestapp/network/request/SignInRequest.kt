package com.stu.paymentstestapp.network.request

import com.google.gson.annotations.SerializedName

data class SignInRequest(
    @SerializedName("login") val login: String,
    @SerializedName("password") val password: String
)
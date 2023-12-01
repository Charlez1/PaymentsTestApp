package com.stu.paymentstestapp.network.response

import com.google.gson.annotations.SerializedName

data class SignInResponse(
    @SerializedName("success") val success: String,
    @SerializedName("error") val error: ErrorResponse?,
    @SerializedName("response") val response: TokenResponse?
)



//data class SignInSuccessResponse(
//    @SerializedName("success") val success: String,
//    @SerializedName("response") val response: TokenResponse
//)

data class TokenResponse(
    @SerializedName("token") val token: String
)
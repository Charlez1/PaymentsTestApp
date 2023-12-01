package com.stu.paymentstestapp.network

import com.stu.paymentstestapp.network.request.SignInRequest
import com.stu.paymentstestapp.network.response.PaymentResponse
import com.stu.paymentstestapp.network.response.SignInResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Query

interface EasypayApiService {

    @POST("login")
    suspend fun signIn(
        @Header("app-key") appKey: String = ApiConstants.APP_KEY,
        @Header("v") version: String = ApiConstants.VERSION,
        @Body request: SignInRequest
    ): SignInResponse

    @GET("payments")
    suspend fun getSportClubInfo(
        @Header("app-key") appKey: String = ApiConstants.APP_KEY,
        @Header("v") version: String = ApiConstants.VERSION,
        @Header("token") token: String
    ): PaymentResponse
}
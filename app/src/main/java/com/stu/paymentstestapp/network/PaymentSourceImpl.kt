package com.stu.paymentstestapp.network

import com.stu.paymentstestapp.AuthenticationException
import com.stu.paymentstestapp.entity.Payment
import com.stu.paymentstestapp.network.request.SignInRequest
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentSourceImpl @Inject constructor(
    private val easypayApiService: EasypayApiService
) : PaymentSource {

    override suspend fun signInAndGetToken(login: String, password: String): String {
        val signInRequest = SignInRequest(login, password)

        try {
            val response = easypayApiService.signIn(request = signInRequest)

            if (response.response != null)
                return response.response.token
            else if(response.error != null)
                throw AuthenticationException(response.error.errorMsg)
            else
                throw IllegalStateException("Unexpected response type")
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getPaymentList(token: String): List<Payment> {
        try {
            val response = easypayApiService.getSportClubInfo(token = token)

            if (response.response != null)
                return response.toListPayment()
            else if(response.error != null)
                throw AuthenticationException(response.error.errorMsg)
            else
                throw IllegalStateException("Unexpected response type")
        } catch (e: Exception) {
            throw e
        }
    }
}
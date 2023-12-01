package com.stu.paymentstestapp.network

import com.stu.paymentstestapp.entity.Payment

interface PaymentSource {

    suspend fun signInAndGetToken(login: String, password: String): String

    suspend fun getPaymentList(token: String): List<Payment>
}
package com.stu.paymentstestapp.features.paymentlist.repositories

import com.stu.paymentstestapp.entity.Payment

interface PaymentListRepository {

    suspend fun getPaymentList(): List<Payment>
}
package com.stu.paymentstestapp.features.paymentlist.repositories

import com.stu.paymentstestapp.InvalidTokenException
import com.stu.paymentstestapp.entity.Payment
import com.stu.paymentstestapp.network.PaymentSource
import com.stu.paymentstestapp.setting.AppSettings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentListRepositoryImpl @Inject constructor(
    private val paymentSource: PaymentSource,
    private val appSettings: AppSettings
): PaymentListRepository {

    override suspend fun getPaymentList(): List<Payment> {
        try {
            val token = appSettings.getCurrentToken()
            if (token != null)
                return paymentSource.getPaymentList(token)
            else
                throw InvalidTokenException("invalid token, please log out")
        } catch (e: Exception) {
            throw e
        }
    }
}
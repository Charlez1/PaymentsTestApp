package com.stu.paymentstestapp.features.login.repositories

import com.stu.paymentstestapp.network.PaymentSource
import com.stu.paymentstestapp.setting.AppSettings
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthenticationRepositoryImpl @Inject constructor(
    private val paymentSource: PaymentSource,
    private val appSettings: AppSettings
): AuthenticationRepository {

    override suspend fun signIn(email: String, password: String) {
        val token = paymentSource.signInAndGetToken(email, password)
        appSettings.setCurrentToken(token)
    }

    override fun logOut() {
        appSettings.removeCurrentToken()
    }

    override fun isSignedIn(): Boolean {
        return appSettings.isSignedIn()
    }
}
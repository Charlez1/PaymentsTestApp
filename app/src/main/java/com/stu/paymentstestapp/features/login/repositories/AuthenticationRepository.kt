package com.stu.paymentstestapp.features.login.repositories


interface AuthenticationRepository {

    suspend fun signIn(email: String, password: String)

    fun logOut()

    fun isSignedIn(): Boolean

}
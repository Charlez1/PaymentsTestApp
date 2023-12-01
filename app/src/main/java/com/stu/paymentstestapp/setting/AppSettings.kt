package com.stu.paymentstestapp.setting


interface AppSettings {

    fun getCurrentToken(): String?

    fun setCurrentToken(token: String)

    fun isSignedIn(): Boolean

    fun removeCurrentToken()
}
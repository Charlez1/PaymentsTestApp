package com.stu.paymentstestapp.setting

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreferencesAppSettings @Inject constructor(
    @ApplicationContext appContext: Context
) : AppSettings {

    private val sharedPreferences = appContext.getSharedPreferences("settings", Context.MODE_PRIVATE)

    override fun setCurrentToken(token: String) {
        val editor = sharedPreferences.edit()
        editor.putString(PREF_CURRENT_USER_TOKEN, token)
        editor.apply()
    }

    override fun getCurrentToken(): String? {

        val token = sharedPreferences.getString(PREF_CURRENT_USER_TOKEN, null)
        return  token
    }

    override fun isSignedIn(): Boolean {
        return getCurrentToken() != null
    }

    override fun removeCurrentToken() {
        val editor = sharedPreferences.edit()
        editor.remove(PREF_CURRENT_USER_TOKEN)
        editor.apply()
    }

    companion object {
        private const val PREF_CURRENT_USER_TOKEN = "currentUid"
    }
}

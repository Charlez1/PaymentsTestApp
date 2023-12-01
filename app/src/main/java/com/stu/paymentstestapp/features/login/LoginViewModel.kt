package com.stu.paymentstestapp.features.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu.paymentstestapp.AuthenticationException
import com.stu.paymentstestapp.features.login.repositories.AuthenticationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val repository: AuthenticationRepository
) : ViewModel() {

    private val _showErrorToastEvent = MutableStateFlow("")
    val showErrorToastEvent: StateFlow<String> = _showErrorToastEvent.asStateFlow()

    fun signIn(login: String, password: String, navigateToPaymentScreen: () -> Unit) {
        viewModelScope.launch {
            try {
                repository.signIn(login, password)
                navigateToPaymentScreen()
            } catch (e: AuthenticationException) {
                _showErrorToastEvent.value = e.message ?: ""
            }
        }
    }
}
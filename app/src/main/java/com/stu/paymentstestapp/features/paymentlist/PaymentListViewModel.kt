package com.stu.paymentstestapp.features.paymentlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.stu.paymentstestapp.AuthenticationException
import com.stu.paymentstestapp.entity.Payment
import com.stu.paymentstestapp.features.login.repositories.AuthenticationRepository
import com.stu.paymentstestapp.features.paymentlist.repositories.PaymentListRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PaymentListViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepository,
    private val paymentListRepository: PaymentListRepository
): ViewModel() {

    private val _paymentList = MutableStateFlow<List<Payment>>(emptyList())
    val paymentList: StateFlow<List<Payment>> = _paymentList.asStateFlow()

    private val _showErrorToastEvent = MutableStateFlow("")
    val showErrorToastEvent: StateFlow<String> = _showErrorToastEvent.asStateFlow()

    fun getPaymentList() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                _paymentList.value = paymentListRepository.getPaymentList()
            } catch (e: AuthenticationException) {
                _showErrorToastEvent.value = e.message ?: ""
            }
        }
    }

    fun logOut(navigateToLogInScreen: () -> Unit) {
        authenticationRepository.logOut()
        navigateToLogInScreen()
    }
}
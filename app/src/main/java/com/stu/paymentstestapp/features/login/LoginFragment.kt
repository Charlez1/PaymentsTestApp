package com.stu.paymentstestapp.features.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment.Companion.findNavController
import androidx.navigation.fragment.findNavController
import com.stu.paymentstestapp.R
import com.stu.paymentstestapp.databinding.FragmentSignInBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_sign_in) {

    private lateinit var binding: FragmentSignInBinding

    private val viewModel by viewModels<LoginViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSignInBinding.bind(view)
        binding.signInButton.setOnClickListener { onSignInButtonPressed() }

        observeShowErrorToastEvent()
    }

    private fun onSignInButtonPressed() {
        viewModel.signIn(
            login = binding.emailEditText.text.toString(),
            password = binding.passwordEditText.text.toString(),
            navigateToPaymentScreen = { findNavController().navigate(R.id.action_loginFragment_to_paymentListFragment) }

        )
    }
    private fun observeShowErrorToastEvent() {
        lifecycleScope.launch {
            viewModel.showErrorToastEvent.collect { errorMessage ->
                if(errorMessage != "")
                    showToast(errorMessage)
            }
        }
    }

    private fun showToast(errorMessage: String) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
    }
}
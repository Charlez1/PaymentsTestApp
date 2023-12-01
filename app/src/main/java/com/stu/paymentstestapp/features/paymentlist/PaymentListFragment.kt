package com.stu.paymentstestapp.features.paymentlist

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.stu.paymentstestapp.R
import com.stu.paymentstestapp.databinding.FragmentPaymentListBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class PaymentListFragment : Fragment(R.layout.fragment_payment_list) {

    private val viewModel by viewModels<PaymentListViewModel>()

    private lateinit var binding: FragmentPaymentListBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPaymentListBinding.inflate(inflater, container, false)
        binding.logoutButton.setOnClickListener { onLofOutButtonPressed() }

        val adapter = PaymentListAdapter()

        viewModel.getPaymentList()
        observeShowErrorToastEvent()
        observeDialogList(adapter)

        setUpAdapter(adapter)

        return binding.root
    }

    private fun onLofOutButtonPressed() {
        viewModel.logOut(
            navigateToLogInScreen = {
                val navController = findNavController()
                navController.popBackStack(navController.graph.startDestinationId, false)
                navController.navigate(R.id.action_paymentListFragment_to_loginFragment)
            }
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

    private fun observeDialogList(adapter: PaymentListAdapter) = lifecycleScope.launch(Dispatchers.Default) {
        viewModel.paymentList.collect { list ->
            withContext(Dispatchers.Main) {
                adapter.paymentList = list
            }
        }
    }

    private fun showToast(errorMessage: String) {
        Toast.makeText(requireContext(), errorMessage, Toast.LENGTH_LONG).show()
    }

    private fun setUpAdapter(adapter: PaymentListAdapter) {
        val layoutManager = LinearLayoutManager(requireContext())
        binding.paymentsList.layoutManager = layoutManager
        binding.paymentsList.adapter = adapter
    }
}
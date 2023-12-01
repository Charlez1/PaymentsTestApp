package com.stu.paymentstestapp.features.paymentlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.stu.paymentstestapp.databinding.PaymentItemBinding
import com.stu.paymentstestapp.entity.Payment

class PaymentListAdapter : RecyclerView.Adapter<PaymentListAdapter.PaymentListViewHolder>() {

    var paymentList: List<Payment> = emptyList()
        set(newValue) {
            field = newValue
            notifyDataSetChanged()
        }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentListViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PaymentItemBinding.inflate(inflater, parent, false)

        return PaymentListViewHolder(binding)
    }

    override fun getItemCount(): Int = paymentList.size

    override fun onBindViewHolder(holder: PaymentListViewHolder, position: Int) {
        val weatherDayInfo = paymentList[position]
        holder.bind(weatherDayInfo)
    }

    inner class PaymentListViewHolder(
        private val binding: PaymentItemBinding
    ): RecyclerView.ViewHolder(binding.root) {

        fun bind(payment: Payment) {
            with(binding) {
                paymentTitleTextView.text = payment.title
                paymentAmountTextView.text = payment.amount
                paymentCreatedTextView.text = payment.created
            }
        }
    }
}
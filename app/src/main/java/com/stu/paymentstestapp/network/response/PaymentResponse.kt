package com.stu.paymentstestapp.network.response

import com.google.gson.annotations.SerializedName
import com.stu.paymentstestapp.DateTimeUtils.formatDateTimeByFormat
import com.stu.paymentstestapp.entity.Payment
import java.util.Date

data class PaymentResponse(
    @SerializedName("success") val success: String,
    @SerializedName("error") val error: ErrorResponse?,
    @SerializedName("response") val response: List<PaymentItemResponse>
) {
    fun toListPayment() : List<Payment> {
        val list : MutableList<Payment> = mutableListOf()
        this.response.forEach {
            list.add(it.toPayment())
        }
        return list
    }
}

data class PaymentItemResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("amount") val amount: Any?,
    @SerializedName("created") val created: Long?
) {
    fun toPayment() : Payment {
        return Payment(
            id = id,
            title = title,
            amount = if(amount is String && amount == "") "unknown"
                else amount?.toString() ?: "unknown",
            created = created?.let { formatDateTimeByFormat(created*1000) } ?: "unknown"
        )
    }
}


package com.stu.paymentstestapp

import java.text.SimpleDateFormat
import java.util.*

object DateTimeUtils {

    fun formatDateTimeByFormat(timestamp: Long?): String {
        val timeFormat = SimpleDateFormat("dd.MM.yy HH:mm", Locale.ENGLISH)
        return timeFormat.format(timestamp).lowercase()
    }
}

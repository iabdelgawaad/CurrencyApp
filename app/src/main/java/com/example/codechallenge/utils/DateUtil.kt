package com.example.codechallenge.utils

import android.util.Log
import java.text.SimpleDateFormat
import java.util.*

class DateUtil {

    companion object{
        val DATE_FORMAT = "yyyy-mm-dd"
        fun getCurrentDate(): String? {
            val c = Calendar.getInstance()
            val sdf = SimpleDateFormat(DATE_FORMAT, Locale.ENGLISH)
            val strDate = sdf.format(c.time)
            Log.d("", "" + strDate)
            return strDate
        }
    }

}
package com.dev.fi.footballapps.utils

import android.annotation.SuppressLint
import android.view.View
import java.text.SimpleDateFormat
import java.util.*

/**
 ****************************************
created by -manca-
.::manca.fi@gmail.com ::.
 ****************************************
 */

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.invisible() {
    visibility = View.GONE
}

@SuppressLint("SimpleDateFormat")
fun reformatDate(value: String?): String? {
    val pFormat = SimpleDateFormat("yyyy-MM-dd")
    val date: Date = pFormat.parse(value)
    val nformat = SimpleDateFormat("EEE, dd MMM yyyy")
    return nformat.format(date)
}

fun setToLocalTime(value: String?): String? {
    return if(value != null){
        val pFormat = SimpleDateFormat("HH:mm")
        val date: Date = pFormat.parse(value)
        pFormat.format(date)
    }else{
        ""
    }
}

fun lineText(value: String?): String? {
    return if ((value != "") || (value != null)) {
        var newValue = value?.replace(";", ";\n", true)
        newValue = newValue?.replace("\n ", "\n", true)
        newValue
    } else {
        value
    }
}

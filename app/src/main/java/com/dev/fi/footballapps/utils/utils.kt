package com.dev.fi.footballschedule2.utils

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
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
    val nformat = SimpleDateFormat("dd MMM yyyy")
    return nformat.format(date)
}

fun lineText(value: String?): String? {
    return if ((value != "") || (value != null)) {
        var newValue = value?.replace(";", ";\n", true)
        newValue = newValue?.replace("\n ", "\n", true)
        newValue
    }else{
        value
    }
}

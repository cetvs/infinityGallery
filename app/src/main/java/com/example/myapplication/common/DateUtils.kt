package com.example.myapplication.common

import java.sql.Date
import java.text.SimpleDateFormat

fun Long.convertLongToTime(): String {
    val date = Date(this)
    val format = SimpleDateFormat("dd.MM.yyyy")
    return format.format(date)
}

fun currentTimeToLong(): Long {
    return System.currentTimeMillis()
}

fun convertDateToLong(date: String): Long {
    val df = SimpleDateFormat("dd.MM.yyyy")
    return df.parse(date).time
}
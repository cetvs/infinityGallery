package com.example.myapplication.common

import androidx.compose.ui.text.TextRange
import androidx.compose.ui.text.input.TextFieldValue

var pred = 0

fun TextFieldValue.transformToPhone(): TextFieldValue {
    // надо бы переделать)
    val str = this.text
    val size = str.length
    if (size == 0){
        return TextFieldValue(text = "")
    }
    var result = "+7 ("
    var index = 4

    if (size > 4) {
        result += str[4]
        index = 5
    }

    if (size > 5) {
        result += str[5]
        index = 6
    }
    if (size > 6) {
        result += "${str[6]}) "
        index = 9
    }

    if (size > 9) {
        result += str[9]
        index = 10
    }
    if (size > 10) {
        result += str[10]
        index = 11
    }
    if (size > 11) {
        result += "${str[11]} "
        index = 13
    }

    if (size > 13) {
        result += str[13]
        index = 14
    }
    if (size > 14) {
        result += "${str[14]} "
        index = 16
    }

    if (size > 16) {
        result += str[16]
        index = 17
    }
    if (size > 17) {
        result += str[17]
        index = 18
    }
    return TextFieldValue(text = result, selection = TextRange(index))
}

fun TextFieldValue.phoneToString(): String {
    val str = this.text
    val set = setOf(' ', '(', ')')
    var result = ""
    str.forEach { if (!set.contains(it)) result += it }
    return result
}
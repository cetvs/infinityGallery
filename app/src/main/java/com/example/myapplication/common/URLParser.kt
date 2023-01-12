package com.example.myapplication.common

class URLParser(private val symbol: Char) {

    fun encode(string: String): String{
        var res = ""
        for ( ch in string){
            res += if (ch == '/') symbol else ch
        }
        return res
    }

    fun decode(string: String): String{
        var res = ""
        for ( ch in string){
            res += if (ch == symbol) '/' else ch
        }
        return res
    }
}
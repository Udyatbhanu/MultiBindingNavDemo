package com.bhanu.baliyar.multibindingsnavdemo.core

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val data: T) : ResponseWrapper<T>()
    data class Error(val message: String? = null, val error: Throwable? = null) :
        ResponseWrapper<Nothing>()

    object Loading  : ResponseWrapper<Nothing>()
}
package com.bhanu.baliyar.multibindingsnavdemo.data.models

enum class LogType {
    SERVICE,
    DATABASE,
    APP
}

data class Log(val content: String, val type: LogType = LogType.APP)
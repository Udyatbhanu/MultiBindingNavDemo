package com.bhanu.baliyar.multibindingsnavdemo.data.repositories

import com.bhanu.baliyar.multibindingsnavdemo.data.models.Log

interface LogsRepository {

    suspend fun uploadLogs(log : Log)
}
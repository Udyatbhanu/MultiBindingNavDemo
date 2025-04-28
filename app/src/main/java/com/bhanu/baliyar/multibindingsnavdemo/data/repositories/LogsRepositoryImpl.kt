package com.bhanu.baliyar.multibindingsnavdemo.data.repositories

import com.bhanu.baliyar.multibindingsnavdemo.data.models.Log
import javax.inject.Inject

class LogsRepositoryImpl @Inject constructor() : LogsRepository {
    override suspend fun uploadLogs(log: Log) {
        android.util.Log.d("Uploading logs type ${log.type}", log.content)
    }
}
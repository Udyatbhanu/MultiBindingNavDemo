package com.bhanu.baliyar.multibindingsnavdemo.core.analytics

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.bhanu.baliyar.multibindingsnavdemo.core.di.LogsEntryPoint
import com.bhanu.baliyar.multibindingsnavdemo.data.models.LogType
import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.LogsRepository
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class AnalyticsService : Service() {

    private lateinit var analyticsTasks: Set<AnalyticsTask>
    private lateinit var logsRepository: LogsRepository
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        val entryPoint =
            EntryPointAccessors.fromApplication(applicationContext, AnalyticsEntryPoint::class.java)

        val logsRepoEntryPoint = EntryPointAccessors.fromApplication(
            applicationContext,
            LogsEntryPoint::class.java
        )


        analyticsTasks = entryPoint.analyticsTasks
        logsRepository = logsRepoEntryPoint.logsRepository()
        Log.d("Analytics Service ", "Service Created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        scope.launch {
            runAnalyticsTasks()
        }
        return START_STICKY
    }

    private suspend fun runAnalyticsTasks() {
        analyticsTasks.forEach { task ->
            try {
                logsRepository.uploadLogs(
                    com.bhanu.baliyar.multibindingsnavdemo.data.models.Log(
                        content = "Uploading analytics task logs",
                        type = LogType.SERVICE
                    ),
                )
                task.execute()
            } catch (e: Exception) {
                Log.d("Analytics Service", "There was an exception")
            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scope.cancel()
        Log.d("Analytics Service ", "Service Destroyed")
    }

    override fun onBind(intent: Intent?): IBinder? = null
}
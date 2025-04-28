package com.bhanu.baliyar.multibindingsnavdemo.core.analytics

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import dagger.hilt.android.EntryPointAccessors
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

class AnalyticsService : Service() {

    private lateinit var analyticsTasks: Set<AnalyticsTask>
    val scope = CoroutineScope(SupervisorJob() + Dispatchers.IO)

    override fun onCreate() {
        super.onCreate()
        val entryPoint =
            EntryPointAccessors.fromApplication(applicationContext, AnalyticsEntryPoint::class.java)
        analyticsTasks = entryPoint.analyticsTasks
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
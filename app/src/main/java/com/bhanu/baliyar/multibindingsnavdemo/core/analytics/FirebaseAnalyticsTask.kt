package com.bhanu.baliyar.multibindingsnavdemo.core.analytics

import javax.inject.Inject

class FirebaseAnalyticsTask @Inject constructor() : AnalyticsTask {
    override suspend fun execute() {
        println("FirebaseAnalyticsTask run")
    }
}
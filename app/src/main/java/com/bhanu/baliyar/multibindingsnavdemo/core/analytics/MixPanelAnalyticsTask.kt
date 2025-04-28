package com.bhanu.baliyar.multibindingsnavdemo.core.analytics

import javax.inject.Inject

class MixPanelAnalyticsTask @Inject constructor() : AnalyticsTask {
    override suspend fun execute() {
       println("MixPanelAnalyticsTask run")
    }
}
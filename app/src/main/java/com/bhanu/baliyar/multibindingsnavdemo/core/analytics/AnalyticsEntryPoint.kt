package com.bhanu.baliyar.multibindingsnavdemo.core.analytics

import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface AnalyticsEntryPoint {
    val analyticsTasks : Set<@JvmSuppressWildcards AnalyticsTask>
}
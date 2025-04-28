package com.bhanu.baliyar.multibindingsnavdemo.core.di

import com.bhanu.baliyar.multibindingsnavdemo.core.analytics.AnalyticsTask
import com.bhanu.baliyar.multibindingsnavdemo.core.analytics.FirebaseAnalyticsTask
import com.bhanu.baliyar.multibindingsnavdemo.core.analytics.MixPanelAnalyticsTask
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
interface AnalyticsModule {

    @Binds
    @IntoSet
    fun provideFirebaseAnalytics(analyticsTask: FirebaseAnalyticsTask): AnalyticsTask

    @Binds
    @IntoSet
    fun provideMixPanelAnalytics(analyticsTask: MixPanelAnalyticsTask): AnalyticsTask
}
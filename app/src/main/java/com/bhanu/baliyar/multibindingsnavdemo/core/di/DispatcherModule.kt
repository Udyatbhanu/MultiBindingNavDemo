package com.bhanu.baliyar.multibindingsnavdemo.core.di

import com.bhanu.baliyar.multibindingsnavdemo.core.dispatcher.DispatcherProvider
import com.bhanu.baliyar.multibindingsnavdemo.core.dispatcher.DispatcherProviderImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class DispatcherModule {

    @Binds
    @Singleton
    abstract fun provideDispatcherProvider(dispatcherProvider : DispatcherProviderImpl): DispatcherProvider
}
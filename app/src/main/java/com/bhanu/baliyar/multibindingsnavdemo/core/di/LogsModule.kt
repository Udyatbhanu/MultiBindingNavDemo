package com.bhanu.baliyar.multibindingsnavdemo.core.di

import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.LogsRepository
import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.LogsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@EntryPoint
@InstallIn(SingletonComponent::class)
interface LogsEntryPoint {
    fun logsRepository(): LogsRepository
}

@Module
@InstallIn(SingletonComponent::class)
interface LogsModule {

    @Binds
    @Singleton
    fun provideLogsRepository(logsRepository: LogsRepositoryImpl): LogsRepository
}
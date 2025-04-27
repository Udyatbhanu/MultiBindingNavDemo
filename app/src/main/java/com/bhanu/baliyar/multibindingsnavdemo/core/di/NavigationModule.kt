package com.bhanu.baliyar.multibindingsnavdemo.core.di

import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenEntry
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.HomeScreenEntry
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.SettingsScreenEntry
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {

    @Binds
    @IntoSet
    fun bindHomeScreenEntry(homeScreenEntry: HomeScreenEntry): ScreenEntry

    @Binds
    @IntoSet
    fun bindHomeSettingsScreenEntry(homeScreenEntry: SettingsScreenEntry): ScreenEntry
}
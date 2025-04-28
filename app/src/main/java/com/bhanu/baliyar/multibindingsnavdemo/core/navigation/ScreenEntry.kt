package com.bhanu.baliyar.multibindingsnavdemo.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


interface ScreenEntry {

    val route: String
    @Composable
    fun Content(navController: NavHostController)
}

@EntryPoint
@InstallIn(SingletonComponent::class)
interface ScreenEntryPoint {
    fun screenEntries(): Set<@JvmSuppressWildcards ScreenEntry>
}
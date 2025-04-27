package com.bhanu.baliyar.multibindingsnavdemo.core

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.navigation.compose.rememberNavController


@Composable
fun LocalAppProvider(content: @Composable () -> Unit) {
    val navController = rememberNavController()
    val localSpacing = rememberLocalSpacing()


    CompositionLocalProvider(LocalNavProvider provides navController, LocalSpacingProvider provides localSpacing) {
        content()
    }
}
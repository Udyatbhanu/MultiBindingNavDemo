package com.bhanu.baliyar.multibindingsnavdemo.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalNavController
import com.bhanu.baliyar.multibindingsnavdemo.presentation.common.NavigationCommand
import com.bhanu.baliyar.multibindingsnavdemo.presentation.common.NavigationViewModel
import dagger.hilt.android.EntryPointAccessors


sealed class ScreenRoute(val route: String) {
    object Home : ScreenRoute(route = "home")
    object Settings : ScreenRoute(route = "settings")
}

@Composable
fun AppNav(

) {
    val navController = LocalNavController
    val navigationViewModel = hiltViewModel<NavigationViewModel>()

    LaunchedEffect(Unit) {
        navigationViewModel.navigationCommands.collect { command ->
            when (command) {
                is NavigationCommand.Navigate -> navController.navigate(command.route)
                NavigationCommand.Back -> navController.popBackStack()
            }
        }
    }
    val context = LocalContext.current.applicationContext
    val screens =
        EntryPointAccessors.fromApplication(context, ScreenEntryPoint::class.java).screenEntries()
    NavHost(navController = navController, startDestination = ScreenRoute.Home.route) {
        screens.forEach { entry ->
            composable(entry.route) {
                entry.Content(navController)
            }
        }
    }
}
package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalNavController
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenEntry
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenRoute
import javax.inject.Inject


class HomeScreenEntry @Inject constructor() : ScreenEntry {
    override val route: String
        get() = ScreenRoute.Home.route

    @Composable
    override fun Content(navController: NavHostController) {
        HomeScreen()
    }
}

@Composable
fun HomeScreen() {
    val navaController = LocalNavController
    Text(text = "Home Screen")
}

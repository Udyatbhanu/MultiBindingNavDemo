package com.bhanu.baliyar.multibindingsnavdemo.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalNavController
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.AppNav
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenRoute


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DemoApp() {
    val navController = LocalNavController
    val currentRoute = navController.currentBackStackEntryAsState().value?.destination?.route
        ?: ScreenRoute.Home.route
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Home") }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary,
                    titleContentColor = MaterialTheme.colorScheme.onPrimary
                )
            )
        },
        bottomBar = {
            NavigationBar(modifier = Modifier.padding(4.dp)) {
                NavigationBarItem(
                    selected = currentRoute == ScreenRoute.Home.route,
                    onClick = {
                        if (currentRoute != ScreenRoute.Home.route) {
                            navController.navigate(ScreenRoute.Home.route)
                        }
                    },
                    icon = { Icon(imageVector = Icons.Default.Home, contentDescription = "") },
                    label = { Text("Home") }
                )
                NavigationBarItem(
                    selected = currentRoute == ScreenRoute.Settings.route,
                    onClick = {
                        if (currentRoute != ScreenRoute.Settings.route) {
                            navController.navigate(ScreenRoute.Settings.route)
                        }
                    },
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings"
                        )
                    })
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
           AppNav()
        }
    }
}
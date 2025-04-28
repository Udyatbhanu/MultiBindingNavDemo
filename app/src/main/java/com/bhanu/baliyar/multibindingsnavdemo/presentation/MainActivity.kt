package com.bhanu.baliyar.multibindingsnavdemo.presentation

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bhanu.baliyar.multibindingsnavdemo.core.analytics.AnalyticsService
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalAppProvider
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.AdvancedBoxScreen
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.AdvancedCoordinatorScreen
import com.bhanu.baliyar.multibindingsnavdemo.presentation.theme.MultiBindingsNavDemoTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val serviceIntent = Intent(this, AnalyticsService::class.java)
        startService(serviceIntent)
        setContent {
            MultiBindingsNavDemoTheme {
                LocalAppProvider {
                    DemoApp()
//                    AdvancedCoordinatorScreen()
//                    AdvancedBoxScreen()
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MultiBindingsNavDemoTheme {
        DemoApp()
    }
}
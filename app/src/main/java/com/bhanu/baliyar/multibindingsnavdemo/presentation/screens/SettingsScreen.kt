package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.bhanu.baliyar.multibindingsnavdemo.R
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalAppSpacing
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenEntry
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenRoute
import com.bhanu.baliyar.multibindingsnavdemo.presentation.theme.MultiBindingsNavDemoTheme
import javax.inject.Inject


class SettingsScreenEntry @Inject constructor() : ScreenEntry {
    override val route: String
        get() = ScreenRoute.Settings.route

    @Composable
    override fun Content(navController: NavHostController) {
        SettingsScreen()
    }
}

@Composable
fun SettingsScreen() {
    var isChecked by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(LocalAppSpacing.medium)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Text(stringResource(R.string.dark_theme))
            Spacer(modifier = Modifier.width(LocalAppSpacing.medium))
            Switch(
                checked = isChecked,
                onCheckedChange = { isChecked = !isChecked }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SettingsScreenPreview() {
    MultiBindingsNavDemoTheme {
        SettingsScreen()
    }
}
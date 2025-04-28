package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalAppSpacing
import com.bhanu.baliyar.multibindingsnavdemo.presentation.theme.MultiBindingsNavDemoTheme

@Composable
fun AdvancedRowScreen() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
            .background(Color.LightGray)
            .padding(8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Start",
            modifier = Modifier
                .background(Color.Red)
                .padding(8.dp)
        )

        // Spacer that grows dynamically
        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {},
            modifier = Modifier
                .background(Color.Blue)
                .padding(8.dp)
        ) {
            Text("Button 1")
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = {},
            modifier = Modifier
                .background(Color.Green)
                .padding(8.dp)
        ) {
            Text("Button 2")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedRowScreenPreview(){
    MultiBindingsNavDemoTheme {
        AdvancedRowScreen()
    }
}
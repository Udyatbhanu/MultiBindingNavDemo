package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bhanu.baliyar.multibindingsnavdemo.presentation.theme.MultiBindingsNavDemoTheme

@Composable
fun AdvancedBoxScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        // Background layer
//        Box(
//            Modifier
//                .matchParentSize()
//                .background(Color.DarkGray)
//        )

        // Center item
        Box(
            Modifier
                .align(Alignment.Center)
                .size(200.dp)
                .background(Color.Blue)
        )

        // Top-Start corner item
        Box(
            Modifier
                .align(Alignment.TopStart)
                .padding(16.dp)
                .size(100.dp)
                .background(Color.Red)
        )

        // Bottom-End corner item
        Box(
            Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .size(80.dp)
                .background(Color.Green)
        )

        // Z-index stacking example
        Text(
            text = "Overlay Text",
            modifier = Modifier
                .align(Alignment.Center)
                .background(Color.White.copy(alpha = 0.8f))
                .padding(8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun AdvancedBoxScreenPreview(){
    MultiBindingsNavDemoTheme {
        AdvancedBoxScreen()
    }
}
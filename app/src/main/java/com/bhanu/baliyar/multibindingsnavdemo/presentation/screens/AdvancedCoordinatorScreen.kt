package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.style.TextAlign

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AdvancedCoordinatorScreen() {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val fabVisible = remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            LargeTopAppBar(
                title = { Text("Collapsing AppBar") },
                scrollBehavior = scrollBehavior,
                colors = TopAppBarDefaults.largeTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            if (fabVisible.value) {
                FloatingActionButton(onClick = {}) {
                    Text("+")
                }
            }
        },
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection)
    ) { innerPadding ->

        val listState = rememberLazyListState()
        val scope = rememberCoroutineScope()

        LaunchedEffect(listState.firstVisibleItemScrollOffset) {
            fabVisible.value = listState.firstVisibleItemIndex == 0
        }

        LazyColumn(
            contentPadding = innerPadding,
            state = listState,
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(50) { index ->
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(80.dp)
                        .background(if (index % 2 == 0) Color.LightGray else Color.White),
                    contentAlignment = Alignment.Center
                ) {
                    Text("Item $index", textAlign = TextAlign.Center)
                }
            }
        }
    }
}
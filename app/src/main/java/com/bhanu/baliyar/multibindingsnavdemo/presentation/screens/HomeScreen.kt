package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import coil3.compose.AsyncImage
import com.bhanu.baliyar.multibindingsnavdemo.R
import com.bhanu.baliyar.multibindingsnavdemo.core.LocalAppSpacing
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenEntry
import com.bhanu.baliyar.multibindingsnavdemo.core.navigation.ScreenRoute
import com.bhanu.baliyar.multibindingsnavdemo.data.models.Product
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.vm.HomeScreenViewModel
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
    val viewModel = hiltViewModel<HomeScreenViewModel>()
    val state by viewModel.state.collectAsState()
    LaunchedEffect(Unit) {
        viewModel.fetchProducts()
    }
    when (val result = state) {
        is HomeScreenState.Success -> ProductsGrid(result.data)
        is HomeScreenState.Error -> ErrorView(result.message)
        is HomeScreenState.Loading -> LoadingView()
    }
}


@Composable
fun ProductsGrid(products: List<Product>) {
    LazyVerticalGrid(modifier = Modifier.padding(8.dp), columns = GridCells.Fixed(2)) {
        items(products) { product ->
            ProductCard(product)
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(modifier = Modifier
        .padding(LocalAppSpacing.medium)
        .size(200.dp)) {
        Column(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                modifier = Modifier.height(150.dp),
                model = product.thumbnail,
                contentDescription = product.description,
                placeholder = painterResource(R.drawable.rounded_downloading_24)
            )
            Spacer(modifier = Modifier.height(LocalAppSpacing.small))
            Text(
                text = product.title,
                textAlign = TextAlign.Center,
                maxLines = 1,
                modifier = Modifier.padding(LocalAppSpacing.small),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }

}

@Composable
fun LoadingView(){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorView(message : String ){
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
        Text(text = "There was an error processing the request")
    }
}



sealed class HomeScreenState() {
    data class Success(val data: List<Product>) : HomeScreenState()
    data class Error(val message: String) : HomeScreenState()
    object Loading : HomeScreenState()
}
package com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.vm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bhanu.baliyar.multibindingsnavdemo.core.ResponseWrapper
import com.bhanu.baliyar.multibindingsnavdemo.data.models.Log
import com.bhanu.baliyar.multibindingsnavdemo.data.models.LogType
import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.LogsRepository
import com.bhanu.baliyar.multibindingsnavdemo.data.repositories.ProductsRepository
import com.bhanu.baliyar.multibindingsnavdemo.presentation.screens.HomeScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val repository: ProductsRepository,
    private val logsRepository: LogsRepository
) :
    ViewModel() {
    private val _state = MutableStateFlow<HomeScreenState>(HomeScreenState.Loading)
    val state: StateFlow<HomeScreenState> = _state.asStateFlow()

    init{
        fetchProducts()
    }
    fun fetchProducts() {

        repository.getProducts().catch {
            HomeScreenState.Error(message = "There was an error processing the response")
        }.onEach { result ->
                _state.value =
                    when (result) {
                        is ResponseWrapper.Success -> {
                            logsRepository.uploadLogs(
                                Log(
                                    content = "Product fetch Success",
                                    type = LogType.APP
                                )
                            )
                            HomeScreenState.Success(
                                data = result.data.products
                            )
                        }

                        is ResponseWrapper.Error -> HomeScreenState.Error(
                            message = result.message ?: "There was an error processing the response"
                        )

                        ResponseWrapper.Loading -> HomeScreenState.Loading
                    }
            }.launchIn(viewModelScope) // launch the Flow

    }
}
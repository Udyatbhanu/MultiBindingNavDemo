package com.bhanu.baliyar.multibindingsnavdemo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


sealed class NavigationCommand{
    data class Navigate(val route : String) : NavigationCommand()
    object Back : NavigationCommand()
}
@HiltViewModel
class NavigationViewModel @Inject constructor(): ViewModel(){
    private val _navigationCommands = MutableSharedFlow<NavigationCommand>()
    val navigationCommands  = _navigationCommands

    fun navigateTo(route : String){
        viewModelScope.launch {
            _navigationCommands.emit(NavigationCommand.Navigate(route = route))
        }
    }

    fun back(route : String){
        viewModelScope.launch {
            _navigationCommands.emit(NavigationCommand.Back)
        }
    }
}

package com.example.pstocks.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pstocks.utils.Sessions
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel(){
     fun navigateToOtherPages(route: String) {
         viewModelScope.launch {
             Sessions.navigation.emit(route);
         }
    }
}
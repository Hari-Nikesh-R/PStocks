package com.example.pstocks.ui.algo

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AlgoViewModel @Inject constructor(): ViewModel(){
    var searchString by mutableStateOf("")
}
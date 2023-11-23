package com.example.pstocks.utils

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import kotlinx.coroutines.flow.MutableSharedFlow

object Sessions {
    var navigation = MutableSharedFlow<String>(0)
    var moveBack = MutableSharedFlow<Boolean>()
    var stringEvent = MutableSharedFlow<String?>()
    var defaultBottomBarNeeded by mutableStateOf(true)

}
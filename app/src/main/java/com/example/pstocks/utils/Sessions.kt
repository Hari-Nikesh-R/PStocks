package com.example.pstocks.utils

import kotlinx.coroutines.flow.MutableSharedFlow

object Sessions {
    var navigation = MutableSharedFlow<String>(0)
    var stringEvent = MutableSharedFlow<String?>()
}
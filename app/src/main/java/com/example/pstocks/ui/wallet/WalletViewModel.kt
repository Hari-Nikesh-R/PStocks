package com.example.pstocks.ui.wallet

import androidx.lifecycle.ViewModel
import com.example.pstocks.utils.Sessions
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WalletViewModel @Inject constructor() : ViewModel() {
init {
    Sessions.defaultBottomBarNeeded = false
}
}
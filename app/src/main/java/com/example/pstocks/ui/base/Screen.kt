package com.example.pstocks.ui.base

sealed class Screen(val route: String) {
    object WalletScreen : Screen("wallet_screen")
}
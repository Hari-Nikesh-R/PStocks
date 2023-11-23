package com.example.pstocks.ui.base

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.pstocks.ui.algo.AlgoView
import com.example.pstocks.ui.home.BottomBarScreen
import com.example.pstocks.ui.home.HomeView
import com.example.pstocks.ui.market.MarketView
import com.example.pstocks.ui.menu.MenuView
import com.example.pstocks.ui.wallet.WalletView

@Composable
fun CommonNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {

    }
}
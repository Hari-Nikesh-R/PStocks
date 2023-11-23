package com.example.pstocks.ui.home

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import com.example.pstocks.R
import com.example.pstocks.ui.home.BottomBarScreen.Algo.enabled

sealed class BottomBarScreen(val route: String, val title: String, var enabled: Boolean?, @DrawableRes val icon: Int) {
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        enabled = false,
        icon =  R.drawable.ic_home_icon
    )

    object Algo : BottomBarScreen(
        route = "algo",
        title = "Algo",
        enabled = false,
        icon =R.drawable.ic_algo_icon
    )

    object Market : BottomBarScreen(
        route = "market",
        title = "Market",
        enabled = false,
        icon = R.drawable.ic_market_icon_enabled
    )
    object Menu : BottomBarScreen(
        route = "menu",
        title = "Menu",
        enabled = false,
        icon = R.drawable.ic_menu_icon
    )
}
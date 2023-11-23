package com.example.pstocks.utils

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ContentAlpha
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentColor
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.pstocks.ui.algo.AlgoView
import com.example.pstocks.ui.home.BottomBarScreen
import com.example.pstocks.ui.home.HomeView
import com.example.pstocks.ui.market.MarketView
import com.example.pstocks.ui.menu.MenuView
import com.example.pstocks.ui.theme.ThemeBlack
import com.example.pstocks.ui.theme.ThemeYellow

@Composable
fun BottomNavigationGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = BottomBarScreen.Home.route) {
        composable(route = BottomBarScreen.Home.route) {
            HomeView(hiltViewModel())
        }
        composable(route = BottomBarScreen.Algo.route) {
            AlgoView(hiltViewModel())
        }
        composable(route = BottomBarScreen.Market.route) {
            MarketView(hiltViewModel())
        }
        composable(route = BottomBarScreen.Menu.route) {
            MenuView(hiltViewModel())
        }
    }
}

@Composable
fun BottomBar(navController: NavHostController) {
    val screens = listOf(
        BottomBarScreen.Home,
        BottomBarScreen.Algo,
        BottomBarScreen.Market,
        BottomBarScreen.Menu,
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination
    Box(modifier = Modifier.fillMaxWidth(1f)) {
        BottomNavigation(
            modifier = Modifier.clip(
                shape = MaterialTheme.shapes.medium.copy(
                    topEnd = CornerSize(32.dp),
                    topStart = CornerSize(32.dp)
                )
            ), backgroundColor = ThemeBlack
        ) {
            screens.forEachIndexed { index, screen ->
                screen.enabled = currentDestination?.hierarchy?.any {
                    it.route == screen.route
                } == true

                if (index == 2) {
                    Spacer(
                        modifier = Modifier
                            .width(44.dp)
                            .background(ThemeBlack)
                    )
                }
                AddItem(
                    screen = screen,
                    selected = screen.enabled,
                    navController = navController
                )
            }
        }

    }
}

@Composable
fun CustomFloatingActionButton() {
    FloatingActionButton(
        onClick = {},
        backgroundColor = ThemeYellow
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null,)
    }
}

@Composable
fun RowScope.AddItem(
    screen: BottomBarScreen,
    selected: Boolean?,
    navController: NavHostController
) {
    if (selected != null) {
        BottomNavigationItem(
            modifier = Modifier.background(ThemeBlack),
            label = {
                Text(text = screen.title, color = Color.White)
            },
            icon = {
                Icon(
                    painterResource(id = screen.icon),
                    contentDescription = "Navigation Icon",
                    tint = if(screen.enabled == true) Color.White else Color.Gray
                )
            },
            selected = selected,
            unselectedContentColor = LocalContentColor.current.copy(alpha = ContentAlpha.disabled),
            onClick = {
                navController.navigate(screen.route) {
                    popUpTo(navController.graph.findStartDestination().id)
                    launchSingleTop = true
                }
            }
        )
    }
}
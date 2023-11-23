package com.example.pstocks.ui.home


import android.se.omapi.Session
import androidx.compose.material.FabPosition
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pstocks.ui.base.BottomBar
import com.example.pstocks.ui.base.BottomNavigationGraph
import com.example.pstocks.ui.base.CustomBottomBar
import com.example.pstocks.ui.base.CustomFloatingActionButton
import com.example.pstocks.utils.Sessions
import com.example.pstocks.utils.Sessions.defaultBottomBarNeeded

@Composable
fun MainView() {
    val navController =  rememberNavController()
    Navigation(navController = navController)
    PopBack(navController = navController)
    Scaffold (
        floatingActionButton = { CustomFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
           if(defaultBottomBarNeeded)
                BottomBar(navController = navController) else CustomBottomBar()
        }) {
        it.calculateBottomPadding()
        Surface {
            BottomNavigationGraph(navController = navController);
        }
    }

}

@Composable
fun Navigation(navController: NavHostController) {
    LaunchedEffect(Unit)
    {
        Sessions.navigation.collect { route ->
            navController.navigate(route)
        }
    }
}

@Composable fun PopBack(navController: NavHostController) {
    LaunchedEffect(Unit) {
        Sessions.moveBack.collect { isBackAction ->
            if (isBackAction) {
                navController.navigateUp()
            }
        }
    }
}


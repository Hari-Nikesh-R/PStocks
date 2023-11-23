package com.example.pstocks.ui.home


import androidx.compose.foundation.background
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pstocks.utils.BottomBar
import com.example.pstocks.utils.BottomNavigationGraph

@Composable
fun MainView() {
    val navController =  rememberNavController()
    Scaffold (bottomBar = { BottomBar(navController = navController)}) {
        it.calculateBottomPadding()
        Surface {
            BottomNavigationGraph(navController = navController);
        }
    }

}


package com.example.pstocks.ui.home


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FabPosition
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.pstocks.utils.BottomBar
import com.example.pstocks.utils.BottomNavigationGraph
import com.example.pstocks.utils.CustomFloatingActionButton

@Composable
fun MainView() {
    val navController =  rememberNavController()
    Scaffold (
        floatingActionButton = { CustomFloatingActionButton() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = true,
        bottomBar = {
                BottomBar(navController = navController)
        }) {
        it.calculateBottomPadding()
        Surface {
            BottomNavigationGraph(navController = navController);
        }
    }

}


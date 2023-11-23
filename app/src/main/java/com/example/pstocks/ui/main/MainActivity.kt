package com.example.pstocks.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import com.example.pstocks.ui.home.MainView
import com.example.pstocks.ui.theme.PStocksTheme
import com.example.pstocks.utils.Sessions
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PStocksTheme {
                MainView()
            }
        }
    }
}



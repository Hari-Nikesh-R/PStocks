package com.example.pstocks.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.pstocks.ui.home.MainView
import com.example.pstocks.ui.theme.PStocksTheme
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



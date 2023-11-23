package com.example.pstocks.utils

import androidx.compose.ui.graphics.Color


object Utility {
    fun getColorFromHex(colorString: String): Color {
        return Color(android.graphics.Color.parseColor("#" + colorString))
    }
}

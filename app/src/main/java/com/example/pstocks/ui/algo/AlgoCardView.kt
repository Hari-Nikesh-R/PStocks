package com.example.pstocks.ui.algo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pstocks.R
import com.example.pstocks.ui.theme.ThemeBlack

@Preview
@Composable
fun AlgoCardView() {
    Card(modifier = Modifier
        .padding(4.dp).padding(vertical = 4.dp),
        elevation = 12.dp, shape = RoundedCornerShape(24.dp), backgroundColor = ThemeBlack
    ) {
        Box  {
            Column {
                Row(
                    modifier = Modifier
                        .padding(12.dp)
                        .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        painter = painterResource(id = R.drawable.ic_algo_menu),
                        contentDescription = null
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "Streak Ninja",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.h4.fontSize,
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                }
                AlgoCardDescContent(titleFront = "Total profit", valueFront = "1400", titleRear = "Percentage win", valueRear = "50%")
                AlgoCardDescContent(titleFront ="Algo age", valueFront = "3 Years", titleRear = "Completed trades", valueRear = "1400")
                Spacer(modifier = Modifier.height(60.dp))
            }
            Column(modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(12.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        modifier = Modifier.padding(horizontal = 12.dp),
                        text = "View Detail",
                        fontWeight = FontWeight.Bold,
                        fontSize = MaterialTheme.typography.caption.fontSize,
                        color = Color.Yellow,
                        textAlign = TextAlign.Start
                    )
                    Image(
                        painter = painterResource(id = R.drawable.ic_algo_view_detail),
                        contentDescription = null
                    )
                }
            }
        }

    }
}

@Composable
fun AlgoCardDescContent(titleFront: String, valueFront: String, titleRear: String, valueRear: String) {
    Row(
        modifier = Modifier
            .padding(12.dp)
            .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = titleFront,
            fontSize = MaterialTheme.typography.caption.fontSize,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )
        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = valueFront,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.caption.fontSize,
            color = Color.White,
            textAlign = TextAlign.Start
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            modifier = Modifier.padding(horizontal = 12.dp),
            text = titleRear,
            fontSize = MaterialTheme.typography.caption.fontSize,
            color = Color.Gray,
            textAlign = TextAlign.Start
        )

        Text(
            modifier = Modifier.padding(horizontal = 4.dp),
            text = valueRear,
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.caption.fontSize,
            color = Color.White,
            textAlign = TextAlign.Start
        )
    }
}
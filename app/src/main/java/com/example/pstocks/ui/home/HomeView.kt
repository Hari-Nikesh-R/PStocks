package com.example.pstocks.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pstocks.R


@Preview
@Composable
fun HomeView() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 36.dp, start = 12.dp)
        ){
            Image(painterResource(id = R.drawable.wallet),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.18f)
                    .aspectRatio(1.0f, matchHeightConstraintsFirst = true),
                contentDescription = null)
            Image(painterResource(id = R.drawable.wallet),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.18f)
                    .aspectRatio(1.0f, matchHeightConstraintsFirst = true),
                contentDescription = null)
            Image(painterResource(id = R.drawable.notification),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.28f)
                    .aspectRatio(1.0f, matchHeightConstraintsFirst = true),
                contentDescription = null)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.padding(12.dp),
            text = "Current Balance",
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Light,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                text = "$",
                fontSize = MaterialTheme.typography.body1.fontSize,
                fontWeight = FontWeight.Light,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Text(
                modifier = Modifier.padding(8.dp),
                text = "275,458",
                fontSize = MaterialTheme.typography.h3.fontSize,
                fontWeight = FontWeight.Light,
                color = Color.White,
                textAlign = TextAlign.Center
            )
        }
        Text(
            modifier = Modifier.padding(4.dp),
            text = "15% last 30 days",
            fontSize = MaterialTheme.typography.subtitle1.fontSize,
            fontWeight = FontWeight.Light,
            color = Color.White,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))
            Box(
                modifier = Modifier
                    .size(400.dp, 64.dp)
                    .clip(RoundedCornerShape(32.dp))
                    .background(Color.DarkGray),
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Image(painterResource(id = R.drawable.ic_stock_drop),
                        contentScale = ContentScale.FillHeight,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.2f)
                            .aspectRatio(1.0f, matchHeightConstraintsFirst = true).padding(start = 12.dp).padding(vertical = 4.dp),
                        contentDescription = null)
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Spent",
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "$17,547.99",
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            fontWeight = FontWeight.Light,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                    Image(painterResource(id = R.drawable.ic_stock_up),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth(0.4f)
                            .aspectRatio(1.0f, matchHeightConstraintsFirst = true).padding(start = 12.dp).padding(vertical = 4.dp),
                        contentDescription = null)
                    Column(modifier = Modifier.padding(8.dp)) {
                        Text(
                            text = "Profit/Loss",
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray,
                            textAlign = TextAlign.Center
                        )
                        Text(
                            text = "+$15,310.39",
                            fontSize = MaterialTheme.typography.body2.fontSize,
                            fontWeight = FontWeight.Light,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }

    }
}
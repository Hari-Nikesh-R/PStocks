package com.example.pstocks.ui.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
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
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.pstocks.R
import com.example.pstocks.ui.algo.AlgoViewModel
import com.example.pstocks.ui.base.Screen
import com.example.pstocks.ui.theme.ThemeBlack
import com.example.pstocks.utils.Sessions
import kotlinx.coroutines.launch

@Composable
fun WalletView(viewModel: WalletViewModel) {
    val scope = rememberCoroutineScope()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround,
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(top = 36.dp)
        ){
            Image(
                painterResource(id = R.drawable.ic_back_arrow),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.18f)
                    .clickable {
                        Sessions.defaultBottomBarNeeded = true
                        scope.launch {
                            Sessions.moveBack.emit(true)
                        }
                    }
                    .aspectRatio(1.0f, matchHeightConstraintsFirst = true),
                contentDescription = null)
            Text(
                modifier = Modifier.padding(12.dp),
                text = "Wallet",
                fontSize = MaterialTheme.typography.h5.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center
            )
            Image(
                painterResource(id = R.drawable.notification),
                contentScale = ContentScale.Fit,
                alignment = Alignment.Center,
                modifier = Modifier
                    .fillMaxWidth(0.28f)
                    .aspectRatio(1f, matchHeightConstraintsFirst = true),
                contentDescription = null)
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            modifier = Modifier.padding(4.dp),
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
        Row (modifier = Modifier.fillMaxWidth(2f), horizontalArrangement = Arrangement.SpaceEvenly) {
            AmountCardView("Send Amount", R.drawable.ic_wallet_sendmoney_arrow)
            AmountCardView("Add Amount", R.drawable.ic_wallet_addmoney_arrow)
        }
    }
}


@Composable
fun AmountCardView(message: String, logo: Int) {
    Card(backgroundColor = ThemeBlack, elevation = 12.dp, shape = RoundedCornerShape(24.dp)) {
        Column(
            modifier = Modifier
                .padding(12.dp)
        ) {
            Image(
                painter = painterResource(id = logo),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(44.dp))
            Row(
                modifier = Modifier.width(120.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(0.5f),
                    text = message,
                    overflow = TextOverflow.Visible,
                    fontSize = MaterialTheme.typography.body2.fontSize,
                    fontWeight = FontWeight.Light,
                    color = Color.White,
                    textAlign = TextAlign.Start
                )
                Image(
                    painter = painterResource(id = R.drawable.ic_wallet_proceed),
                    contentDescription = null
                )
            }
        }
    }
}
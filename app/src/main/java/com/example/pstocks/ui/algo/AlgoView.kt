package com.example.pstocks.ui.algo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.pstocks.R
import com.example.pstocks.ui.theme.ThemeBlack

@Composable
fun AlgoView(viewModel: AlgoViewModel) {
    val focusRequester = remember { FocusRequester() }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .padding(12.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Algo",
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Start
            )
            Image(
                painter = painterResource(id = R.drawable.ic_algo_menu),
                contentDescription = null
            )
        }

        //todo: Need to put dynamic value
        TextField(
            value = viewModel.searchString,
            placeholder = {
                Text("Search", color = Color.White)
            },
            modifier = Modifier
                .fillMaxWidth(1f)
                .background(ThemeBlack, shape = RoundedCornerShape(24.dp)),
            singleLine = true,
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Search,
                    tint = Color.White,
                    contentDescription = ""
                )
            },
            colors = TextFieldDefaults.textFieldColors(
                textColor = ThemeBlack,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            ),
            maxLines = 1,
            textStyle = TextStyle(color = Color.White),
            onValueChange = { viewModel.searchString = it },
        )
        Text(
            modifier = Modifier.padding(12.dp),
            text = "See recommended algos first",
            fontSize = MaterialTheme.typography.caption.fontSize,
            color = Color.White,
            textAlign = TextAlign.Start
        )
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            for (i in 1..10) {
                AlgoCardView()
            }
            Spacer(modifier = Modifier.height(40.dp))
        }


    }
}
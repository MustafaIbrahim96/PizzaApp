package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.pizzaapp.R

@Composable
fun HeaderPizzaTitle(modifier : Modifier = Modifier){
    Row(
        modifier = modifier
            .padding(horizontal = 12.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_arrow_back),
            contentDescription = "Back Icon"
        )

        Text(
            "Pizza",
            style = TextStyle(
                fontSize = 24.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight.Bold
            )
        )

        Icon(
            painter = painterResource(R.drawable.ic_favorite),
            contentDescription = "Favorite Icon"
        )
    }
}

@Preview
@Composable
private fun HeaderPizzaTitlePreview() {
    HeaderPizzaTitle()
}
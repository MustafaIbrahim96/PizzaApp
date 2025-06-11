package com.mustafa.pizzaapp.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mustafa.pizzaapp.R

@Composable
fun BoxImagePizza(modifier : Modifier = Modifier) {
    Box(modifier = modifier.padding(top =18.dp)){
        Image(
            painter = painterResource(R.drawable.img_plate),
            contentDescription = "Pizza table",
            modifier = Modifier
                .align(Alignment.Center)
                .size(280.dp)
        )
        Image( painter = painterResource(R.drawable.img_bread_1),
            contentDescription = "Pizza table",
            modifier = Modifier
                .align(Alignment.Center)
                .size(220.dp))

    }
}

@Preview
@Composable
private fun BoxImagePizzaPreview() {
    BoxImagePizza()
}
package com.mustafa.pizzaapp.screen.composable

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun PizzaSizeButton(modifier: Modifier = Modifier, pizzaSize:String) {

    Box(
        modifier = modifier
            .shadow(6.dp, CircleShape)
            .clip(CircleShape)
            .size(48.dp)
            .background(Color.White)
    ) {
        Box(modifier = Modifier.align(Alignment.Center)) {
            Text(pizzaSize, modifier = Modifier)
        }
    }
}
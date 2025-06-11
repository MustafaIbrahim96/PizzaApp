package com.mustafa.pizzaapp.screen.composable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun RowButtonsPizzaSize(modifier: Modifier = Modifier) {
    Row(modifier = modifier) {
        PizzaSizeButton(modifier = Modifier.padding(horizontal = 6.dp), "S")
        PizzaSizeButton(modifier = Modifier.padding(horizontal = 6.dp), "M")
        PizzaSizeButton(modifier = Modifier.padding(horizontal = 6.dp), "L")
    }
}

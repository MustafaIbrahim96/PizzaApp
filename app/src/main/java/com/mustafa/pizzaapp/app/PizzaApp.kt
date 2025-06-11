package com.mustafa.pizzaapp.app

import androidx.compose.runtime.Composable
import com.mustafa.pizzaapp.screen.PizzaScreen
import com.mustafa.pizzaapp.ui.theme.PizzaAppTheme

@Composable
fun PizzaApp(){
    PizzaAppTheme {
        PizzaScreen()
    }
}
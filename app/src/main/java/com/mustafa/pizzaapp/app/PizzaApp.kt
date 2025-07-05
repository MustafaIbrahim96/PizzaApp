package com.mustafa.pizzaapp.app

import androidx.compose.runtime.Composable
import com.mustafa.pizzaapp.presentation.screen.PizzaScreen
import com.mustafa.pizzaapp.app.theme.PizzaAppTheme

@Composable
fun PizzaApp(){
    PizzaAppTheme {
        PizzaScreen()
    }
}
package com.mustafa.pizzaapp.presentation.model

data class PizzaModel(
    val id : Int,
    val breadRes : Int,
    val ingredients: List<IngredientModel> = emptyList(),
)

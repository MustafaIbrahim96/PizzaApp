package com.mustafa.pizzaapp.presentation.model

data class IngredientModel(
    val id : Int,
    val imageRes: Int,
    val images: List<IngredientImageModel> = emptyList(),
    val selected: Boolean = false,
)
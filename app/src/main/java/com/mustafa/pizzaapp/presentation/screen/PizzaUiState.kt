package com.mustafa.pizzaapp.presentation.screen

import com.mustafa.pizzaapp.presentation.Util.Util
import com.mustafa.pizzaapp.presentation.model.PizzaModel

data class PizzaUiState(
    val pizzaList: List<PizzaModel> = emptyList(),
    val pizzaSize: PizzaSize = PizzaSize.MEDIUM,
    val pizza : PizzaModel = Util.pizzaList[0]
)


enum class PizzaSize(val sizeName: String) {
    SMALL("small"),
    MEDIUM("medium"),
    LARGE("large")

}
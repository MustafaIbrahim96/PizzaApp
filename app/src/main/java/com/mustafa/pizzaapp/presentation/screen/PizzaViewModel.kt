package com.mustafa.pizzaapp.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mustafa.pizzaapp.presentation.Util.Util
import com.mustafa.pizzaapp.presentation.model.IngredientModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class PizzaViewModel : ViewModel() {
    private val _state = MutableStateFlow(PizzaUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            getPizzaList()
        }
    }

    private fun getPizzaList() {
        _state.update {
            it.copy(
                pizzaList = Util.pizzaList
            )
        }
    }

    fun onClickSizePizza(size: PizzaSize) {
        _state.update { it.copy(pizzaSize = size) }
    }

    fun onClickIngredient(ingredientModel: IngredientModel) {

        _state.update { pizzaState ->
            val updatePizzaList = pizzaState.pizzaList.map { pizza ->
                if (pizza.id == state.value.pizza.id) {
                    pizza.copy(
                        ingredients = pizza.ingredients.map { ingredient ->
                            if (ingredient.id == ingredientModel.id) ingredient.copy(selected = !ingredient.selected) else ingredient
                        }
                    )
                } else pizza
            }

            pizzaState.copy(
                pizzaList = updatePizzaList,
                pizza = updatePizzaList.first { it.id == pizzaState.pizza.id }
            )
        }
    }

    fun setPizza(page: Int) {
        _state.update { it.copy(pizza = state.value.pizzaList[page]) }
    }

}
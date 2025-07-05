package com.mustafa.pizzaapp.di

import com.mustafa.pizzaapp.presentation.screen.PizzaViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { PizzaViewModel() }
}
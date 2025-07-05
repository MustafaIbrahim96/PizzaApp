package com.mustafa.pizzaapp.presentation.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.pizzaapp.presentation.screen.composable.PizzaComposerWithIngredient
import com.mustafa.pizzaapp.presentation.screen.composable.ButtonAddToCard
import com.mustafa.pizzaapp.presentation.screen.composable.HeaderPizzaTitle
import com.mustafa.pizzaapp.presentation.screen.composable.RowButtonsPizzaSize
import com.mustafa.pizzaapp.presentation.model.IngredientModel
import com.mustafa.pizzaapp.presentation.screen.composable.RowCustomizePizzaIngredient
import org.koin.androidx.compose.koinViewModel

@Composable
fun PizzaScreen(viewModel: PizzaViewModel = koinViewModel()) {
    val state by viewModel.state.collectAsState()
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { state.pizzaList.size }
    )
    viewModel.setPizza(pagerState.settledPage)
    PizzaContent(
        state = state,
        pagerState = pagerState,
        onClickPizzaSize = viewModel::onClickSizePizza,
        onClickIngredient = viewModel::onClickIngredient
    )
}

@Composable
fun PizzaContent(
    state: PizzaUiState,
    pagerState: PagerState,
    onClickPizzaSize: (PizzaSize) -> Unit,
    onClickIngredient: (IngredientModel) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 12.dp)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderPizzaTitle()
        PizzaComposerWithIngredient(
            pagerState = pagerState,
            pizzaSize = state.pizzaSize,
            pizzaList = state.pizzaList
        )
        Spacer(Modifier.weight(1f))
        Text(
            text = "$17", style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Spacer(Modifier.weight(1f))
        RowButtonsPizzaSize(
            selectedSize = state.pizzaSize,
            onClickPizzaSize = onClickPizzaSize
        )
        Spacer(Modifier.weight(1f))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp),
            text = "CUSTOMIZE YOUR PIZZA",
            style = TextStyle(
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                color = Color.Gray.copy(alpha = 0.43f)
            )
        )
        Spacer(Modifier.weight(0.6f))
        RowCustomizePizzaIngredient( pizza = state.pizza,
            onClickIngredient = onClickIngredient,)
        Spacer(Modifier.weight(1f))
        ButtonAddToCard()
        Spacer(Modifier.weight(1f))
    }
}


@Preview
@Composable
private fun PizzaScreenPreview() {
    PizzaScreen()
}
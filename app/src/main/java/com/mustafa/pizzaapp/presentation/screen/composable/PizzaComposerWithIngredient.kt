package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.pizzaapp.R
import com.mustafa.pizzaapp.presentation.model.PizzaModel
import com.mustafa.pizzaapp.presentation.screen.PizzaSize

@Composable
fun PizzaComposerWithIngredient(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    pizzaSize: PizzaSize,
    pizzaList: List<PizzaModel>
) {
    Box(modifier = modifier.padding(top = 18.dp)) {
        Image(
            painter = painterResource(R.drawable.img_plate),
            contentDescription = "Pizza table",
            modifier = Modifier
                .align(Alignment.Center)
                .size(280.dp)
        )
        PizzaPager(
            pagerState = pagerState,
            pizzaList = pizzaList,
            pizzaSize = pizzaSize,
            modifier = Modifier
                .align(Alignment.Center)
        )

    }
}
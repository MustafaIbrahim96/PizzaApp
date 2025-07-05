package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.pizzaapp.presentation.model.PizzaModel
import com.mustafa.pizzaapp.presentation.screen.PizzaSize

@Composable
fun PizzaPager(
    pagerState: PagerState,
    pizzaList: List<PizzaModel>,
    pizzaSize: PizzaSize,
    modifier: Modifier = Modifier,
) {

    val scale = animateFloatAsState(
        targetValue = when (pizzaSize) {
            PizzaSize.SMALL -> 0.75f
            PizzaSize.MEDIUM -> 0.85f
            PizzaSize.LARGE -> 0.93f
        }
    )

    HorizontalPager(
        state = pagerState,
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier,
    ) { page ->

        Box(Modifier.fillMaxWidth()) {
            Box(
                modifier = Modifier
                    .size(270.dp)
                    .scale(scale.value)
                    .align(Alignment.Center),
            ) {
                Image(
                    painter = painterResource(pizzaList[page].breadRes),
                    contentDescription = null,
                )
                pizzaList[page].ingredients
                    .filter { it.selected }
                    .forEach { ingredient ->
                        when (ingredient.id) {
                            1 -> IngredientsImages(images = ingredient.images)
                            2 -> IngredientsImages(images = ingredient.images)
                            3 -> IngredientsImages(images = ingredient.images)
                            4 -> IngredientsImages(images = ingredient.images)
                            5 -> IngredientsImages(images = ingredient.images)
                        }
                    }
            }
        }
    }

}
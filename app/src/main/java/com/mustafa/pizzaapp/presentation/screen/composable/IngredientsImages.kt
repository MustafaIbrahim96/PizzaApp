package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import com.mustafa.pizzaapp.presentation.model.IngredientImageModel

@Composable
fun IngredientsImages(
    images: List<IngredientImageModel>,
    modifier: Modifier = Modifier,
) {
    val scale = remember { Animatable(5f) }

    Box(
        modifier = modifier
            .fillMaxSize()
            .scale(scale.value)
    ) {
        images.forEach { image ->

            val animatedOffsetX by animateDpAsState(targetValue = image.offsetX.dp)
            val animatedOffsetY by animateDpAsState(targetValue = image.offsetY.dp)

            IngredientImage(
                imageRes = image.resId,
                modifier = Modifier.offset(animatedOffsetX.value.dp, animatedOffsetY.value.dp),
            )
        }
    }

    LaunchedEffect(key1 = Unit) {
        scale.animateTo(targetValue = 0.95f)
    }
}
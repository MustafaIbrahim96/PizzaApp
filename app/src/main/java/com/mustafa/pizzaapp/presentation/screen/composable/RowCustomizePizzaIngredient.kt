package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.mustafa.pizzaapp.app.theme.Green10AColor
import com.mustafa.pizzaapp.presentation.model.IngredientModel
import com.mustafa.pizzaapp.presentation.model.PizzaModel

@Composable
fun RowCustomizePizzaIngredient(
    modifier: Modifier = Modifier,
    onClickIngredient: (IngredientModel) -> Unit,
    pizza: PizzaModel
) {

    Row (modifier = modifier.fillMaxWidth()){
        pizza.ingredients.forEachIndexed { index, _ ->
            IngredientRoundedButton(
                onClick = { onClickIngredient(pizza.ingredients[index]) },
                imageRes = pizza.ingredients[index].imageRes,
                modifier = Modifier,
                selected = pizza.ingredients[index].selected
            )
        }
    }

}

@Composable
private fun IngredientRoundedButton(
    onClick: () -> Unit,
    modifier: Modifier,
    imageRes: Int,
    selected : Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier.padding(8.dp).size(60.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = if (selected) Green10AColor else Color.White),
        contentPadding = PaddingValues(0.dp),
    ) {
        Image(
            painter = painterResource(imageRes),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .padding(12.dp)
        )
    }
}


package com.mustafa.pizzaapp.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.pizzaapp.R
import com.mustafa.pizzaapp.screen.composable.BoxImagePizza
import com.mustafa.pizzaapp.screen.composable.ButtonAddToCard
import com.mustafa.pizzaapp.screen.composable.HeaderPizzaTitle
import com.mustafa.pizzaapp.screen.composable.RowButtonsPizzaSize
import com.mustafa.pizzaapp.ui.theme.Green10AColor

@Composable
fun PizzaScreen() {
    PizzaContent()
}

@Composable
fun PizzaContent() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(vertical = 12.dp)
            .padding(WindowInsets.systemBars.asPaddingValues()),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderPizzaTitle()
        BoxImagePizza()
        Spacer(Modifier.weight(1f))
        Text(
            text = "$17", style = TextStyle(
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold
            )
        )
        Spacer(Modifier.weight(1f))
        RowButtonsPizzaSize()
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
        RowCustomizePizzaIngredient(onClick = {})
        Spacer(Modifier.weight(1f))
        ButtonAddToCard()
        Spacer(Modifier.weight(1f))
    }
}



@Composable
fun RowCustomizePizzaIngredient(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Button(
        onClick = onClick,
        modifier = modifier.size(70.dp),
        shape = CircleShape,
        colors = ButtonDefaults.buttonColors(containerColor = Green10AColor),
        contentPadding = PaddingValues(0.dp),
    ) {
        Image(
            painter = painterResource(R.drawable.img_basil_1),
            contentDescription = null,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .clip(CircleShape)
                .padding(12.dp)
        )
    }
}


@Preview
@Composable
private fun PizzaContentPreview() {
    PizzaContent()
}
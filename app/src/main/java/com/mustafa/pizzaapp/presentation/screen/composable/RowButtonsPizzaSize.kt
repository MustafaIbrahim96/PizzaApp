package com.mustafa.pizzaapp.presentation.screen.composable

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.mustafa.pizzaapp.presentation.screen.PizzaSize

@Composable
fun RowButtonsPizzaSize(
    modifier: Modifier = Modifier,
    selectedSize: PizzaSize,
    onClickPizzaSize: (PizzaSize) -> Unit
) {

    val listPizzaSize :List<PizzaSize> = PizzaSize.entries

    val alignment by animateAlignmentAsState(
        targetAlignment = when (selectedSize) {
            PizzaSize.SMALL -> Alignment.CenterStart
            PizzaSize.MEDIUM -> Alignment.Center
            PizzaSize.LARGE -> Alignment.CenterEnd
        }
    )

    Box(modifier = modifier) {
        Box(
            modifier = modifier
                .shadow(6.dp, CircleShape)
                .align(alignment)
                .clip(CircleShape)
                .size(48.dp)
                .background(Color.White)
        )
            Row(
                modifier = Modifier
                    .align(Alignment.Center)
                    .wrapContentWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(48.dp),
            )
            {
                listPizzaSize.forEach { size ->
                    Text(
                        text = size.toString().first().toString(),
                        style = TextStyle(
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                        ),
                        color = Color.Black,
                        modifier = Modifier
                            .clickable(
                                indication = null,
                                interactionSource = remember { MutableInteractionSource() }) {
                                onClickPizzaSize(size)
                            }
                    )
                }
            }


    }
}

@Preview
@Composable
private fun RowButtonsPizzaSizePreview() {
    RowButtonsPizzaSize(onClickPizzaSize = {}, selectedSize = PizzaSize.MEDIUM)
}

@Composable
fun animateAlignmentAsState(
    targetAlignment: Alignment,
): State<Alignment> {
    val biased = targetAlignment as BiasAlignment
    val horizontal by animateFloatAsState(biased.horizontalBias, label = "")
    return remember {
        derivedStateOf {
            BiasAlignment(
                horizontalBias = horizontal,
                verticalBias = 0f
            )
        }
    }
}
package dev.matheusvict.santanderdevweek.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.matheusvict.santanderdevweek.ui.theme.SantanderDevWeekTheme
import dev.matheusvict.santanderdevweek.ui.theme.Spacing_2

@Composable
fun CreditCard(
    modifier: Modifier = Modifier,
    cardNumber: String = "",
) {
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(66.dp),
        containerColor = MaterialTheme.colorScheme.primary,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Spacing_2),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            Text(
                text = "Cartão final $cardNumber",
                style = TextStyle(
                    fontSize = 18.sp,
                    color = Color.White,
                    fontWeight = FontWeight.W600,
                    letterSpacing = 0.18.sp
                )
            )
            Icon(
                imageVector = Icons.Filled.ExpandMore,
                contentDescription = "ExpandMore"
            )
        }
    }
}

@Preview
@Composable
fun CreditCardPreview() {
    SantanderDevWeekTheme {
        CreditCard(cardNumber = "00000")
    }
}
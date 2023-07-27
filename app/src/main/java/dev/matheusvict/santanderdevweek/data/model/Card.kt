package dev.matheusvict.santanderdevweek.data.model

import java.math.BigDecimal

data class Card(
    val id: Long = 0,
    val number: String = "",
    val limit: BigDecimal = BigDecimal.ZERO,
)

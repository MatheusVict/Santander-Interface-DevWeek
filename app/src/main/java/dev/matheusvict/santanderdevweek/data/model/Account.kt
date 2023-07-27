package dev.matheusvict.santanderdevweek.data.model

import java.math.BigDecimal

data class Account(
    val id: Long = 0,
    val number: String = "",
    val agency: String = "",
    val balance: BigDecimal = BigDecimal.ZERO,
    val limit: BigDecimal = BigDecimal.ZERO,
)

package dev.matheusvict.santanderdevweek.data.mocks

import dev.matheusvict.santanderdevweek.data.model.Feature
import dev.matheusvict.santanderdevweek.data.model.News

object Mocks {
    val featureList: List<Feature> = listOf(
        Feature(
            "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pix.svg",
            "Pix"
        ),
        Feature(
            "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/pay.svg",
            "Pagar"
        ),
        Feature(
            "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/transfer.svg",
            "Transferir"
        )
    )

    val newsList: List<News> = listOf(
        News(
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/credit.svg",
            description = "O Santander tem soluções de crédito sob medida pra você. Confira!"
        ),
        News(
            icon = "https://digitalinnovationone.github.io/santander-dev-week-2023-api/icons/insurance.svg",
            description = "Santander Seguro Casa, seu faz-tudo. Mais de 50 serviços pra você. Confira!"
        )
    )
}
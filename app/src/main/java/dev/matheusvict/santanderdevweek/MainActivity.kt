package dev.matheusvict.santanderdevweek

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import dagger.hilt.android.AndroidEntryPoint
import dev.matheusvict.santanderdevweek.data.model.Response
import dev.matheusvict.santanderdevweek.presentation.components.AppTopBar
import dev.matheusvict.santanderdevweek.presentation.components.BalanceCard
import dev.matheusvict.santanderdevweek.presentation.components.CreditCard
import dev.matheusvict.santanderdevweek.presentation.components.Header
import dev.matheusvict.santanderdevweek.presentation.components.MenuItems
import dev.matheusvict.santanderdevweek.presentation.components.NewPages
import dev.matheusvict.santanderdevweek.ui.theme.SantanderDevWeekTheme
import dev.matheusvict.santanderdevweek.ui.theme.Spacing_2
import dev.matheusvict.santanderdevweek.ui.theme.Spacing_3

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val state by viewModel.state.collectAsState()
            SantanderDevWeekTheme {
                MainApp(
                    response = state.response
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainApp(response: Response? = null) =
    Surface(color = MaterialTheme.colorScheme.background) {
        Scaffold(
            topBar = { AppTopBar() },
            content = { innerPadding ->
                ConstraintLayout(
                    modifier = Modifier
                        .padding(innerPadding)
                ) {
                    val (
                        header,
                        spacer,
                        balanceCard,
                        menuItems,
                        creditCard,
                        news,
                    ) = createRefs()
                    Header(
                        modifier = Modifier.constrainAs(header) {
                            centerHorizontallyTo(parent)
                        },
                        name = response?.name ?: "",
                        agency = response?.account?.agency ?: "",
                        number = response?.account?.number ?: "",
                    )
                    Spacer(
                        modifier = Modifier
                            .height(40.dp)
                            .constrainAs(spacer) {

                                top.linkTo(header.bottom)
                                bottom.linkTo(header.bottom)
                            }
                    )
                    BalanceCard(
                        modifier = Modifier.constrainAs(balanceCard) {
                            top.linkTo(spacer.top)
                        },
                        balance = response?.account?.balance ?: 0.0,
                        limit = response?.account?.limit ?: 0.0,
                    )

                    MenuItems(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(
                                horizontal = Spacing_2,
                                vertical = Spacing_3
                            )
                            .constrainAs(menuItems) {
                                top.linkTo(balanceCard.bottom)
                            },
                        features = response?.features ?: emptyList()
                    )

                    CreditCard(
                        modifier = Modifier
                            .padding(
                                horizontal = Spacing_2
                            )
                            .constrainAs(creditCard) {
                                top.linkTo(menuItems.bottom, margin = Spacing_2)
                            },
                        cardNumber = response?.card?.number ?: "0000",
                    )

                    NewPages(
                        modifier = Modifier
                            .padding(
                                horizontal = Spacing_2
                            )
                            .constrainAs(news) {
                                top.linkTo(creditCard.bottom, margin = Spacing_2)
                            },
                        news = response?.news ?: emptyList()
                    )
                }

            }

        )

    }


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SantanderDevWeekTheme {
        MainApp()
    }
}
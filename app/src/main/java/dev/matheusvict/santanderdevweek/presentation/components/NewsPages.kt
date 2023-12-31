package dev.matheusvict.santanderdevweek.presentation.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessAlarm
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.matheusvict.santanderdevweek.data.mocks.Mocks
import dev.matheusvict.santanderdevweek.data.model.News
import dev.matheusvict.santanderdevweek.ui.theme.SantanderDevWeekTheme
import dev.matheusvict.santanderdevweek.ui.theme.Spacing_1
import dev.matheusvict.santanderdevweek.ui.theme.Spacing_2

@Composable
@OptIn(ExperimentalFoundationApi::class)
fun NewPages(
    modifier: Modifier = Modifier,
    news: List<News> = emptyList()
) {
    Column {
        val pagerState = rememberPagerState(pageCount = {
            news.size
        })

        HorizontalPager(state = pagerState) { page ->
            NewsItems(news = news[page])
        }
        Indicator(newsCount = news.size, pageState = pagerState)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Indicator(
    newsCount: Int,
    pageState: PagerState
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Spacing_1),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(newsCount) { iteration ->
            val color = if (pageState.currentPage == iteration)
                MaterialTheme.colorScheme.primary
            else
                Color(0xFFBEC6D4)

            Box(
                modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(Spacing_1)
            )
        }
    }
}

@Composable
fun NewsItems(news: News) {
    AppCard(
        modifier = Modifier
            .fillMaxWidth()
            .height(115.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(Spacing_2),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Image(
                modifier = Modifier.weight(0.2f),
                imageVector = Icons.Filled.AccessAlarm,
                contentDescription = "AcessAlarm"
            )
            Text(
                modifier = Modifier.weight(0.8f),
                text = news.description,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.W400,
                    letterSpacing = 0.14.sp,
                    color = Color(0xFF616161)
                )
            )
        }
    }
}

@Preview
@Composable
fun NewPagesPreview() {
    SantanderDevWeekTheme {
        NewPages(news = Mocks.newsList)
    }
}
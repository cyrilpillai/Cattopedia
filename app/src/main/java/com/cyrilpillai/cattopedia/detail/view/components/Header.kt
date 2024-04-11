package com.cyrilpillai.cattopedia.detail.view.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.cyrilpillai.cattopedia.R
import com.cyrilpillai.cattopedia.ui.theme.Purple40
import com.cyrilpillai.cattopedia.ui.theme.Purple80Transparent

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Header(
    images: List<String>,
    headerHeight: Dp,
    scrollState: ScrollState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(headerHeight)
            .graphicsLayer {
                translationY = -scrollState.value.toFloat() / 2f // Parallax effect
                alpha = (-1f / headerHeight.toPx()) * scrollState.value + 1
            }
    ) {
        val pagerState = rememberPagerState(pageCount = { images.size })
        HorizontalPager(state = pagerState) { page ->
            AsyncImage(
                model = images[page],
                placeholder = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "breed image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxSize()
            )
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) {
                val color = if (pagerState.currentPage == it) Purple40 else Purple80Transparent
                Box(
                    modifier = Modifier
                        .padding(2.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(10.dp)
                )
            }
        }
    }
}


package com.cyrilpillai.cattopedia.list.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import coil.compose.AsyncImage
import com.cyrilpillai.cattopedia.R
import com.cyrilpillai.cattopedia.list.view.model.BreedItem
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiEvent
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiState

@Composable
fun BreedListRoute(
    onBreedClicked: (breedId: String) -> Unit,
    viewModel: BreedListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    BreedListScreen(
        state,
        viewModel::onEvent,
        onBreedClicked
    )
}

@Composable
fun BreedListScreen(
    state: BreedListUiState,
    onEvent: (event: BreedListUiEvent) -> Unit,
    onBreedClicked: (breedId: String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxSize()
    ) {
        when (state) {
            is BreedListUiState.Success -> {
                LazyVerticalStaggeredGrid(
                    columns = StaggeredGridCells.Fixed(2),
                    contentPadding = PaddingValues(12.dp),
                    verticalItemSpacing = 12.dp,
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                ) {
                    items(state.breeds) { BreedView(it, onBreedClicked) }
                }
            }

            is BreedListUiState.Loading -> {
                CircularProgressIndicator()
            }

            else -> Unit
        }
    }
}

@Composable
fun BreedView(
    breedItem: BreedItem,
    onBreedClicked: (breedId: String) -> Unit,
    modifier: Modifier = Modifier
) {
    val density = LocalDensity.current
    var height by remember { mutableStateOf(0.dp) }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(24.dp)
            )
            .clickable { onBreedClicked(breedItem.id) }
    ) {
        AsyncImage(
            model = breedItem.imageUrl,
            placeholder = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "breed image",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .onGloballyPositioned {
                    height = density.run { it.size.height.toDp() }
                }
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(height)
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        )
                    )
                )
        )
        Text(
            text = breedItem.name,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(
                    vertical = 8.dp,
                    horizontal = 12.dp
                )
        )
    }
}

@Preview
@Composable
fun BreedListScreenPreview() {
    BreedListScreen(
        state = BreedListUiState.Success(
            breeds = listOf(
                BreedItem(
                    id = "beng",
                    name = "Bengal",
                    origin = "India",
                    imageUrl = "https://cdn2.thecatapi.com/images/IFXsxmXLm.jpg"
                )
            )
        ),
        onEvent = {},
        onBreedClicked = {}
    )
}
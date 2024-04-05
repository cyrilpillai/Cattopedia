package com.cyrilpillai.cattopedia.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cyrilpillai.cattopedia.list.view.model.BreedItem
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiEvent
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiState

@Composable
fun BreedListRoute(
    onNextClicked: () -> Unit,
    viewModel: BreedListViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    BreedListScreen(
        state,
        viewModel::onEvent,
        onNextClicked
    )
}

@Composable
fun BreedListScreen(
    state: BreedListUiState,
    onEvent: (event: BreedListUiEvent) -> Unit,
    onNextClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is BreedListUiState.Success -> {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2)
                ) {
                    items(state.breeds) { BreedView(it) }
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
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .height(130.dp)
    ) {
        Text(
            text = breedItem.imageUrl
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
        onNextClicked = {}
    )
}
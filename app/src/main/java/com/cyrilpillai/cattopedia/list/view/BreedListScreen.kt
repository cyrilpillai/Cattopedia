package com.cyrilpillai.cattopedia.list.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
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
                Text(
                    text = state.greeting,
                    modifier = modifier
                        .padding(16.dp)
                )
            }

            else -> Unit
        }

        Button(
            onClick = onNextClicked,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Next",
                modifier = modifier
            )
        }

        Button(
            onClick = { onEvent(BreedListUiEvent.NextClicked) },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Initiate Network",
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
fun BreedListScreenPreview() {
    BreedListScreen(
        state = BreedListUiState.Success(
            greeting = "Cattopedia is a demo app showcasing android best practices"
        ),
        onEvent = {},
        onNextClicked = {}
    )
}
package com.cyrilpillai.cattopedia.detail.view

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
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiEvent
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiState

@Composable
fun BreedDetailRoute(
    onPreviousClicked: () -> Unit,
    viewModel: BreedDetailViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    BreedDetailScreen(
        state,
        viewModel::onEvent,
        onPreviousClicked
    )
}

@Composable
fun BreedDetailScreen(
    state: BreedDetailUiState,
    onEvent: (event: BreedDetailUiEvent) -> Unit,
    onPreviousClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (state) {
            is BreedDetailUiState.Success -> {
                Text(
                    text = state.greeting,
                    modifier = modifier
                        .padding(16.dp)
                )
            }

            else -> Unit
        }

        Button(
            onClick = onPreviousClicked,
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Previous",
                modifier = modifier
            )
        }
    }
}

@Preview
@Composable
fun BreedDetailScreenPreview() {
    BreedDetailScreen(
        state = BreedDetailUiState.Success(
            greeting = "This screen shows details of a specific cat breed"
        ),
        onEvent = {},
        onPreviousClicked = {}
    )
}
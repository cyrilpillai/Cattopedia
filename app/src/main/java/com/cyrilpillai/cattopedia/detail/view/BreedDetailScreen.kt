package com.cyrilpillai.cattopedia.detail.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.cyrilpillai.cattopedia.detail.view.components.Body
import com.cyrilpillai.cattopedia.detail.view.components.Header
import com.cyrilpillai.cattopedia.detail.view.components.Title
import com.cyrilpillai.cattopedia.detail.view.components.Toolbar
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailItem
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiEvent
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiState
import com.cyrilpillai.cattopedia.detail.view.model.LevelItem
import com.cyrilpillai.cattopedia.detail.view.model.TemperamentItem

@Composable
fun BreedDetailRoute(
    onBackClicked: () -> Unit,
    viewModel: BreedDetailViewModel = hiltViewModel(),
) {
    val state by viewModel.uiState.collectAsStateWithLifecycle()

    BreedDetailScreen(
        state,
        viewModel::onEvent,
        onBackClicked
    )
}

private val headerHeight = 250.dp
private val toolbarHeight = 64.dp

@Composable
fun BreedDetailScreen(
    state: BreedDetailUiState,
    onEvent: (event: BreedDetailUiEvent) -> Unit,
    onBackClicked: () -> Unit,
    modifier: Modifier = Modifier
) {
    when (state) {
        is BreedDetailUiState.Success -> {
            Box(modifier = modifier) {
                val scrollState = rememberScrollState()
                Body(
                    breedDetailItem = state.breedDetailItem,
                    headerHeight = headerHeight,
                    scrollState = scrollState,
                )
                Header(
                    images = state.breedDetailItem.imageUrls,
                    headerHeight = headerHeight,
                    scrollState = scrollState
                )
                Toolbar(
                    headerHeight = headerHeight,
                    toolbarHeight = toolbarHeight,
                    onBackClicked = onBackClicked,
                    scrollState = scrollState
                )
                Title(
                    text = state.breedDetailItem.name,
                    headerHeight = headerHeight,
                    toolbarHeight = toolbarHeight,
                    scrollState = scrollState
                )
            }
        }

        else -> Unit
    }
}

@Preview
@Composable
fun BreedDetailScreenPreview() {
    BreedDetailScreen(
        state = BreedDetailUiState.Success(
            BreedDetailItem(
                id = "beng",
                name = "Bengal",
                origin = "United States",
                description = "Bengals are a lot of fun to live with, but they're definitely not the cat for everyone, or for first-time cat owners. Extremely intelligent, curious and active, they demand a lot of interaction and woe betide the owner who doesn't provide it.",
                temperament = listOf(
                    TemperamentItem(
                        "Alert",
                        0xFFFFFFFF
                    )
                ),
                altNames = "",
                lifeSpan = "12 - 15",
                indoor = false,
                lap = false,
                experimental = false,
                hairless = false,
                natural = false,
                rare = false,
                rex = false,
                shortLegs = false,
                hypoallergenic = true,
                imageUrls = listOf(
                    "https://cdn2.thecatapi.com/images/IFXsxmXLm.jpg",
                    "https://cdn2.thecatapi.com/images/IFXsxmXLm.jpg"
                ),
                levels = listOf(
                    LevelItem(
                        title = "Adaptability",
                        level = 4f,
                        color = 0xFF78909C
                    )
                )
            )
        ),
        onEvent = {},
        onBackClicked = {}
    )
}
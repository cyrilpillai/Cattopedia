package com.cyrilpillai.cattopedia.list.view.model

sealed class BreedListUiState {
    data object Loading : BreedListUiState()

    data class Success(
        val greeting: String
    ) : BreedListUiState()

    data class Failure(
        val errorMessage: String
    ) : BreedListUiState()
}
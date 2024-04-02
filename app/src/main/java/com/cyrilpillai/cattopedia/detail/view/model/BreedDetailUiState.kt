package com.cyrilpillai.cattopedia.detail.view.model

sealed class BreedDetailUiState {
    data object Loading : BreedDetailUiState()

    data class Success(
        val greeting: String
    ) : BreedDetailUiState()

    data class Failure(
        val errorMessage: String
    ) : BreedDetailUiState()
}
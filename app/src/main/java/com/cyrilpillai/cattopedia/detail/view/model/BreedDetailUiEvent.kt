package com.cyrilpillai.cattopedia.detail.view.model

sealed class BreedDetailUiEvent {
    data object PreviousClicked : BreedDetailUiEvent()
}
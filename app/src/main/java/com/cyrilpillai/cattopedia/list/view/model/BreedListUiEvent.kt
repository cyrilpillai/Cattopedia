package com.cyrilpillai.cattopedia.list.view.model

sealed class BreedListUiEvent {
    data object NextClicked : BreedListUiEvent()
}
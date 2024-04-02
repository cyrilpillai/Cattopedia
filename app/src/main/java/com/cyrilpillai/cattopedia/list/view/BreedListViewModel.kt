package com.cyrilpillai.cattopedia.list.view

import androidx.lifecycle.ViewModel
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiEvent
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BreedListViewModel @Inject constructor() : ViewModel() {
    private var _uiState: MutableStateFlow<BreedListUiState> = MutableStateFlow(
        BreedListUiState.Success(
            greeting = "This screen shows a list of cat breeds"
        )
    )
    val uiState: StateFlow<BreedListUiState> = _uiState.asStateFlow()

    fun onEvent(event: BreedListUiEvent) {
    }
}
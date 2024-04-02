package com.cyrilpillai.cattopedia.detail.view

import androidx.lifecycle.ViewModel
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiEvent
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class BreedDetailViewModel @Inject constructor() : ViewModel() {
    private var _uiState: MutableStateFlow<BreedDetailUiState> = MutableStateFlow(
        BreedDetailUiState.Success(
            greeting = "This screen shows details of a specific cat breed"
        )
    )
    val uiState: StateFlow<BreedDetailUiState> = _uiState.asStateFlow()

    fun onEvent(event: BreedDetailUiEvent) {
    }

}
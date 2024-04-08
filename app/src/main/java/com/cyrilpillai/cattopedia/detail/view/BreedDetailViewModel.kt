package com.cyrilpillai.cattopedia.detail.view

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrilpillai.cattopedia.detail.domain.BreedDetailRepo
import com.cyrilpillai.cattopedia.detail.navigation.BREED_ID_ARG
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailItem
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiEvent
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BreedDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val breedDetailRepo: BreedDetailRepo
) : ViewModel() {
    val uiState: StateFlow<BreedDetailUiState> = breedDetailRepo.getBreed(
        savedStateHandle[BREED_ID_ARG]
    ).map {
        BreedDetailUiState.Success(BreedDetailItem(it))
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = BreedDetailUiState.Loading
    )

    fun onEvent(event: BreedDetailUiEvent) {
    }

}
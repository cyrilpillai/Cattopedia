package com.cyrilpillai.cattopedia.list.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrilpillai.cattopedia.list.domain.BreedListRepo
import com.cyrilpillai.cattopedia.list.view.model.BreedItem
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiEvent
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedListViewModel @Inject constructor(
    private val breedListRepo: BreedListRepo
) : ViewModel() {
    val uiState: StateFlow<BreedListUiState> = breedListRepo.getAllBreeds()
        .map { breeds ->
            BreedListUiState.Success(breeds.map { BreedItem(it) })
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(),
            initialValue = BreedListUiState.Loading
        )

    init {
        viewModelScope.launch {
            if (breedListRepo.getBreedCount() < 1) {
                breedListRepo.fetchAllBreeds()
            }
        }
    }

    fun onEvent(event: BreedListUiEvent) {
        when (event) {
            is BreedListUiEvent.NextClicked -> {
            }
        }
    }
}
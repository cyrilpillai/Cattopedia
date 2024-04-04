package com.cyrilpillai.cattopedia.list.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrilpillai.cattopedia.core.network.ApiService
import com.cyrilpillai.cattopedia.core.network.result.onError
import com.cyrilpillai.cattopedia.core.network.result.onException
import com.cyrilpillai.cattopedia.core.network.result.onSuccess
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiEvent
import com.cyrilpillai.cattopedia.list.view.model.BreedListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BreedListViewModel @Inject constructor(
    private val apiService: ApiService
) : ViewModel() {
    private var _uiState: MutableStateFlow<BreedListUiState> = MutableStateFlow(
        BreedListUiState.Success(
            greeting = "This screen shows a list of cat breeds"
        )
    )
    val uiState: StateFlow<BreedListUiState> = _uiState.asStateFlow()

    fun onEvent(event: BreedListUiEvent) {
        when (event) {
            is BreedListUiEvent.NextClicked -> {
                viewModelScope.launch {
                    apiService.getAllBreeds()
                        .onSuccess {
                            _uiState.value = BreedListUiState.Success(
                                greeting = it.toString()
                            )
                        }
                        .onError { code, message ->
                            _uiState.value = BreedListUiState.Success(
                                greeting = "$code: $message"
                            )
                        }
                        .onException {
                            _uiState.value = BreedListUiState.Success(
                                greeting = it.message.toString()
                            )
                        }
                }
            }
        }
    }
}
package com.cyrilpillai.cattopedia.detail.view

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity
import com.cyrilpillai.cattopedia.detail.domain.BreedDetailRepo
import com.cyrilpillai.cattopedia.detail.navigation.BREED_ID_ARG
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailItem
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiEvent
import com.cyrilpillai.cattopedia.detail.view.model.BreedDetailUiState
import com.cyrilpillai.cattopedia.detail.view.model.LevelItem
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
        BreedDetailUiState.Success(
            BreedDetailItem(
                breedWithImages = it.copy(images = it.images),
                levels = getLevels(it.breed)
            )
        )
    }.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = BreedDetailUiState.Loading
    )

    fun onEvent(event: BreedDetailUiEvent) {
    }

    private fun getLevels(breed: BreedEntity): List<LevelItem> {
        val maxLevel = 5f
        return listOf(
            LevelItem(
                title = "Adaptability",
                level = breed.adaptability / maxLevel
            ),
            LevelItem(
                title = "Affection",
                level = breed.affectionLevel / maxLevel
            ),
            LevelItem(
                title = "Child Friendly",
                level = breed.childFriendly / maxLevel
            ),
            LevelItem(
                title = "Dog Friendly",
                level = breed.dogFriendly / maxLevel
            ),
            LevelItem(
                title = "Stranger Friendly",
                level = breed.strangerFriendly / maxLevel
            ),
            LevelItem(
                title = "Energy",
                level = breed.energyLevel / maxLevel
            ),
            LevelItem(
                title = "Grooming",
                level = breed.grooming / maxLevel
            ),
            LevelItem(
                title = "Health Issues",
                level = breed.healthIssues / maxLevel
            ),
            LevelItem(
                title = "Intelligence",
                level = breed.intelligence / maxLevel
            ),
            LevelItem(
                title = "Shedding",
                level = breed.sheddingLevel / maxLevel
            ),
            LevelItem(
                title = "Social Needs",
                level = breed.socialNeeds / maxLevel
            ),
            LevelItem(
                title = "Vocalisation",
                level = breed.vocalisation / maxLevel
            )
        )
    }
}
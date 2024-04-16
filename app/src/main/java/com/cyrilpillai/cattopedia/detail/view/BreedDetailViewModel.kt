package com.cyrilpillai.cattopedia.detail.view

import android.util.Log
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
import com.cyrilpillai.cattopedia.detail.view.model.TemperamentItem
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
                temperament = getTemperaments(it.breed),
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
                level = breed.adaptability / maxLevel,
                color = 0xFF78909C
            ),
            LevelItem(
                title = "Affection",
                level = breed.affectionLevel / maxLevel,
                color = 0xFFEC407A
            ),
            LevelItem(
                title = "Child Friendly",
                level = breed.childFriendly / maxLevel,
                color = 0xFF03A9f4
            ),
            LevelItem(
                title = "Dog Friendly",
                level = breed.dogFriendly / maxLevel,
                color = 0xFF795548
            ),
            LevelItem(
                title = "Stranger Friendly",
                level = breed.strangerFriendly / maxLevel,
                color = 0xFF43A047
            ),
            LevelItem(
                title = "Energy",
                level = breed.energyLevel / maxLevel,
                color = 0xFFFFFF00
            ),
            LevelItem(
                title = "Grooming",
                level = breed.grooming / maxLevel,
                color = 0xFF06292
            ),
            LevelItem(
                title = "Health Issues",
                level = breed.healthIssues / maxLevel,
                color = 0xFF1976D2
            ),
            LevelItem(
                title = "Intelligence",
                level = breed.intelligence / maxLevel,
                color = 0xFF00ACC1
            ),
            LevelItem(
                title = "Shedding",
                level = breed.sheddingLevel / maxLevel,
                color = 0xFFD7CCC8
            ),
            LevelItem(
                title = "Social Needs",
                level = breed.socialNeeds / maxLevel,
                color = 0xFFEEFF41
            ),
            LevelItem(
                title = "Vocalisation",
                level = breed.vocalisation / maxLevel,
                color = 0xFF64DD17
            )
        )
    }

    private fun getTemperaments(breed: BreedEntity): List<TemperamentItem> {
        return breed.temperament.split(",")
            .map { it.trim() }
            .map {
                Log.d("Cattopedia", "$it - ${temperamentColorMap.containsKey(it)}")
                TemperamentItem(
                    text = it,
                    color = temperamentColorMap[it] ?: 0xFFFFFFFF
                )
            }
    }

    private val temperamentColorMap = hashMapOf(
        "Active" to 0xFF00C853,
        "Adaptable" to 0xFF78909C,
        "Affectionate" to 0xFFEC407A,
        "Agile" to 0xFFFFC107,
        "Alert" to 0xFFE53935,
        "Calm" to 0xFF64b5F6,
        "Curious" to 0xFF9C27b0,
        "Demanding" to 0xFFDD2C00,
        "Dependent" to 0xFF01579B,
        "Devoted" to 0xFF880E4F,
        "Easy Going" to 0xFF00838F,
        "Easygoing" to 0xFF00838F,
        "Energetic" to 0xFFFFFF00,
        "Friendly" to 0xFF43A047,
        "Fun loving" to 0xFFFF7043,
        "Fun-loving" to 0xFFFF7043,
        "Gentle" to 0xFF03A9f4,
        "highly intelligent" to 0xFF006064,
        "Highly interactive" to 0xFF1dE9B6,
        "Independent" to 0xFF757575,
        "Intelligent" to 0xFF00ACC1,
        "Interactive" to 0xFFCDDC39,
        "Lively" to 0xFFFF1744,
        "Loyal" to 0xFFF48FB1,
        "Mischievous" to 0xFFB71C1C,
        "Playful" to 0xFFFFF59D,
        "Quiet" to 0xFF7986CB,
        "Relaxed" to 0xFF448AFF,
        "Social" to 0xFFEEFF41,
        "Sweet" to 0xFFE91E63,
        "Clever" to 0xFF18FFFF,
        "Sensitive" to 0xFFF8BBD0,
        "Outgoing" to 0xFFFF9800,
        "Inquisitive" to 0xFF00E676,
        "Adventurous" to 0xFFF44336,
        "Tenacious" to 0xFF263238,
        "Sweet-tempered" to 0xFF81D4FA,
        "Sociable" to 0xFFFBC02D,
        "Loving" to 0xFFD81B60,
        "Patient" to 0xFFBBDEFB,
        "Sedate" to 0xFF9E9E9E,
        "Shy" to 0xFFC2185B,
        "Sensible" to 0xFF4DD0E1,
        "Peaceful" to 0xFFE1F5FE,
        "Talkative" to 0xFF64DD17,
        "Expressive" to 0xFFC6FF00,
        "Trainable" to 0xFFCFD8DC,
    )
}
package com.cyrilpillai.cattopedia.list.view.model

import com.cyrilpillai.cattopedia.core.database.entity.BreedEntity

sealed class BreedListUiState {
    data object Loading : BreedListUiState()

    data class Success(
        val breeds: List<BreedItem>
    ) : BreedListUiState()

    data class Failure(
        val errorMessage: String
    ) : BreedListUiState()
}

data class BreedItem(
    val id: String,
    val name: String,
    val origin: String,
    val imageUrl: String,
    val imageAspectRatio: Float
) {
    constructor(breedEntity: BreedEntity) : this(
        id = breedEntity.id,
        name = breedEntity.name,
        origin = breedEntity.origin,
        imageUrl = breedEntity.imageUrl,
        imageAspectRatio = breedEntity.imageAspectRatio
    )
}
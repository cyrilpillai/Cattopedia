package com.cyrilpillai.cattopedia.detail.view.model

import com.cyrilpillai.cattopedia.core.database.relation.BreedWithImages

sealed class BreedDetailUiState {
    data object Loading : BreedDetailUiState()

    data class Success(
        val breedDetailItem: BreedDetailItem
    ) : BreedDetailUiState()

    data class Failure(
        val errorMessage: String
    ) : BreedDetailUiState()
}

data class BreedDetailItem(
    val id: String,
    val name: String,
    val origin: String,
    val imageUrls: List<String>
) {
    constructor(breedWithImages: BreedWithImages) : this(
        id = breedWithImages.breed.id,
        name = breedWithImages.breed.name,
        origin = breedWithImages.breed.origin,
        imageUrls = breedWithImages.images.map { it.url }
    )
}
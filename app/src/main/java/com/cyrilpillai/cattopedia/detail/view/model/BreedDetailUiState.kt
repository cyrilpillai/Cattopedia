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
    val description: String,
    val temperament: List<TemperamentItem>,
    val altNames: String,
    val lifeSpan: String,
    val indoor: Boolean,
    val lap: Boolean,
    val experimental: Boolean,
    val hairless: Boolean,
    val natural: Boolean,
    val rare: Boolean,
    val rex: Boolean,
    val shortLegs: Boolean,
    val hypoallergenic: Boolean,
    val imageUrls: List<String>,
    val levels: List<LevelItem>
) {
    constructor(
        breedWithImages: BreedWithImages,
        temperament: List<TemperamentItem>,
        levels: List<LevelItem>
    ) : this(
        id = breedWithImages.breed.id,
        name = breedWithImages.breed.name,
        origin = breedWithImages.breed.origin,
        description = breedWithImages.breed.description,
        temperament = temperament,
        altNames = breedWithImages.breed.altNames,
        lifeSpan = breedWithImages.breed.lifeSpan,
        indoor = breedWithImages.breed.indoor,
        lap = breedWithImages.breed.lap,
        experimental = breedWithImages.breed.experimental,
        hairless = breedWithImages.breed.hairless,
        natural = breedWithImages.breed.natural,
        rare = breedWithImages.breed.rare,
        rex = breedWithImages.breed.rex,
        shortLegs = breedWithImages.breed.shortLegs,
        hypoallergenic = breedWithImages.breed.hypoallergenic,
        imageUrls = breedWithImages.images.map { it.url },
        levels = levels
    )
}

data class TemperamentItem(
    val text: String,
    val color: Long
)

data class LevelItem(
    val title: String,
    val level: Float,
    val color: Long
)